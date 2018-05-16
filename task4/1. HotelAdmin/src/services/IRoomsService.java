package services;

import java.util.Date;
import java.util.List;

import models.hotelroom.*;
import stores.OrdersStore;
import stores.RoomsStore;

public interface IRoomsService {
	
	public void addRoom(RoomsStore rooms, Room room);
	public void removeRoom(RoomsStore rooms, Room room);
	public Room getRoomById(RoomsStore rooms, int roomId);
	public Room getRoomByIdInList(RoomsStore rooms, int idInList);
	public List<Room> getAllRooms(RoomsStore rooms);
	
	public List<Room> getRoomsListSortedByPrice(RoomsStore rooms);
	public List<Room> getFreeRooms(RoomsStore rooms);
	public int getFreeRoomsCount(RoomsStore rooms);
	public List<Room> getRoomsFreeAtDate(RoomsStore rooms, OrdersStore orders, Date d);

}
