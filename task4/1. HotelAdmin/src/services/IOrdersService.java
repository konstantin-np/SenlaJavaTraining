package services;

import java.util.List;

import models.Client;
import models.Order;
import models.Service;
import stores.OrdersStore;

public interface IOrdersService {
	
	
	public void addOrder(Order order);
	public void removeOrder(Order order);
	public Order getOrder(int idInList);
	public List<Order> getAllOrders();
	
	public List<String> getClientsAndRooms();
	public long calcStayingDays(Order o);
	public double calcStayingPrice(Order o);
	public double calcServicesPrice(Order o);
	public double calcSumPrice(Order o);
	public List<Order> getPreviousRoomers(int roomId);
	public List<Service> getClientServices(Client client);
}
