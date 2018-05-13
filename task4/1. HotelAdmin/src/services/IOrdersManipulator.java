package services;

import java.util.List;

import stores.OrdersStore;

public interface IOrdersManipulator {
	public List<String> getClientsAndRooms(OrdersStore orders);
	
	
}
