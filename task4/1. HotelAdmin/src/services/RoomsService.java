package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.senla.training.TextFileWorker;

import comparators.RoomsStarsCountComparator;
import comparators.RoomsPriceComparator;
import models.Order;
import models.hotelroom.*;
import stores.OrdersStore;
import stores.RoomsStore;

public class RoomsService implements IRoomsService {

	public void addRoom(RoomsStore rooms, Room room) {
		rooms.getRooms().add(room);
	}

	public void removeRoom(RoomsStore rooms, Room room) {
		rooms.getRooms().remove(room);
	}

	public Room getRoomById(RoomsStore rooms, int roomId) {
		for (int i = 0; i < rooms.getRooms().size(); i++) {
			if (rooms.getRooms().get(i).getRoomId() == roomId) {
				return rooms.getRooms().get(i);
			}
		}
		return null;
	}

	public Room getRoomByIdInList(RoomsStore rooms, int idInList) {
		return rooms.getRooms().get(idInList);
	}

	public List<Room> getAllRooms(RoomsStore rooms) {
		return rooms.getRooms();
	}
	
	public List<Room> getRoomsListSortedByPrice(RoomsStore rooms) {
		List<Room> roomsList = rooms.getRooms();
		Collections.sort(roomsList, new RoomsPriceComparator());
		return roomsList;
	}

	public List<Room> getFreeRooms(RoomsStore rooms) {
		List<Room> roomsList = rooms.getRooms();
		List<Room> freeRooms = new ArrayList<Room>();
		for (int i = 0; i < roomsList.size(); i++) {
			if (roomsList.get(i).getStatus() == RoomStatus.free)
			freeRooms.add(roomsList.get(i));
		}
		Collections.sort(freeRooms, new RoomsStarsCountComparator());
		return freeRooms;
	}

	public int getFreeRoomsCount(RoomsStore rooms) {
		int count = 0;
		for (Room r : rooms.getRooms()) {
			if (r.getStatus() == RoomStatus.free) {
				count++;
			}
		}
		return count;
	}

	/* returns list of rooms that will be free at Date d */
	public List<Room> getRoomsFreeAtDate(RoomsStore rooms, OrdersStore orders, Date d) {
		List<Room> freeRooms = this.getFreeRooms(rooms); //add rooms free at the moment
		for (Order o : orders.getOrders()) { 
			if (o.getDateEnd().before(d)) { //if order expires before date d
				freeRooms.add(o.getRoom()); //add room from this order to list
			}
		}
		return freeRooms;
	}
	
	public void writeRoomsDataToFile(RoomsStore rooms, String filepath) {
		TextFileWorker tfw = new TextFileWorker(filepath);
		try {
			List<Room> roomsList = rooms.getRooms();
			String roomsData[] = new String[roomsList.size()];
			for (int i = 0; i < roomsList.size(); i++) {
				//roomsData[i] = roomsList.get(i).toString();
				StringBuilder sb = new StringBuilder();
		    	sb.append(roomsList.get(i).getRoomId());
		    	sb.append(", " + roomsList.get(i).getCapacity());
		    	sb.append(", " + roomsList.get(i).getStarsCount());
		    	sb.append(", " + roomsList.get(i).getPrice());
		    	sb.append(", " + roomsList.get(i).getStatus());
		    	roomsData[i] = sb.toString();
			}
			tfw.writeToFile(roomsData);
		}
		catch (Exception e) {
			System.out.println("Error while writing to file");
		}
	}
	
	public List<Room> readRoomsDataFromFile(String filepath) {
		TextFileWorker tfw = new TextFileWorker(filepath);
		List<Room> roomsList = new ArrayList<Room>();
		try {
			String[] roomsData = tfw.readFromFile();
			for (int i = 0; i < roomsData.length; i++) {
				String[] roomData = roomsData[i].split(", ");
				Room r = new Room(Integer.parseInt(roomData[0]), Integer.parseInt(roomData[1]), 
								  Integer.parseInt(roomData[2]), Double.parseDouble(roomData[3]));
				r.setStatus(RoomStatus.valueOf(roomData[4]));
				roomsList.add(r);
			}
			
		}
		catch (Exception e) {
			System.out.println("Error while reading from file");
		}
		return roomsList;
	}

	

}
