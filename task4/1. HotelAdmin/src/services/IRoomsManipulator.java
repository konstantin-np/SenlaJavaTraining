package services;

import java.util.Date;
import java.util.List;

import models.hotelroom.*;
import stores.OrdersStore;
import stores.RoomsStore;

public interface IRoomsManipulator {
	
	public List<Room> getRoomsList(RoomsStore rooms);
	public List<Room> getFreeRooms(RoomsStore rooms);
	public int getFreeRoomsCount(RoomsStore rooms);
	public List<Room> getRoomsFreeAtDate(RoomsStore rooms, OrdersStore orders, Date d);

}
