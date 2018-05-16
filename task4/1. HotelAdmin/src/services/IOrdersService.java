package services;

import java.util.List;

import models.Client;
import models.Order;
import models.Service;
import stores.OrdersStore;

public interface IOrdersService {
	public void addOrder(OrdersStore orders, Order order);
	public void removeOrder(OrdersStore orders, Order order);
	public Order getOrder(OrdersStore orders, int idInList);
	public List<Order> getAllOrders(OrdersStore orders);
	
	public List<String> getClientsAndRooms(OrdersStore orders);
	public long calcStayingDays(Order o);
	public double calcStayingPrice(Order o);
	public double calcServicesPrice(Order o);
	public double calcSumPrice(Order o);
	public List<Order> getPreviousRoomers(OrdersStore orders, int roomId);
	public List<Service> getClientServices(OrdersStore orders, Client client);
}
