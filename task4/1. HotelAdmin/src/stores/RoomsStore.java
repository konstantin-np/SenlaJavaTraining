package stores;

import java.util.ArrayList;
import java.util.List;

import models.hotelroom.Room;

public class RoomsStore implements IRoomsStore {
	
	private List<Room> rooms;
	
	
	public RoomsStore() {
		rooms = new ArrayList<Room>();
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	
	public void addRoom(Room room) {
		rooms.add(room);
	}

	public void removeRoom(Room room) {
		rooms.remove(room);
	}

	public Room getRoomById(int roomId) {
		for (int i = 0; i < this.rooms.size(); i++) {
			if (this.rooms.get(i).getRoomId() == roomId) {
				return this.rooms.get(i);
			}
		}
		return null;
	}

	public Room getRoomByIdInList(int idInList) {
		return this.rooms.get(idInList);
	}

	public List<Room> getAllRooms() {
		return this.rooms;
	}
	
}
