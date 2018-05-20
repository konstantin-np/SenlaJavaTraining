package services;

import java.util.Date;
import java.util.List;

import models.hotelroom.*;
import stores.OrdersStore;
import stores.RoomsStore;

public interface IRoomsService {
	
	public void addRoom(Room room);
	public void removeRoom(Room room);
	public Room getRoomById(int roomId);
	public Room getRoomByIdInList(int idInList);
	public List<Room> getAllRooms();
	
	public List<Room> getRoomsListSortedByPrice();
	public List<Room> getFreeRooms();
	public int getFreeRoomsCount();
	public List<Room> getRoomsFreeAtDate(OrdersStore orders, Date d);

}
