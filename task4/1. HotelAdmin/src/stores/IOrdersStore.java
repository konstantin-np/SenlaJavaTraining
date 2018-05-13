package stores;

import java.util.List;

import models.Order;

public interface IOrdersStore {
	public void addOrder(Order order);
	public void removeOrder(Order order);
	public Order getOrder(int idInList);
	public List<Order> getAllOrders();
}
