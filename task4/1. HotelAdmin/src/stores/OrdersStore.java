package stores;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrdersStore implements IOrdersStore {

	private List<Order> orders;
	
	public OrdersStore (){
		this.orders = new ArrayList<Order>();
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public void removeOrder(Order order) {
		this.orders.remove(order);
	}

	public Order getOrder(int idInList) {
		return this.orders.get(idInList);
	}

	public List<Order> getAllOrders() {
		return this.orders;
	}

	
	
}
