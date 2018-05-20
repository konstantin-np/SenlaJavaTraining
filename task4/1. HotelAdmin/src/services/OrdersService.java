package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import comparators.ClientsNameComparator;
import comparators.ServicesPriceComparator;
import models.Client;
import models.Order;
import models.Service;
import stores.OrdersStore;

public class OrdersService implements IOrdersService {
	
	OrdersStore orders;
	
	public OrdersService() {
		this.orders = new OrdersStore();
	}
	
	public OrdersStore getOrders() {
		return orders;
	}

	public void setOrders(OrdersStore orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		this.orders.getOrders().add(order);
	}

	public void removeOrder(Order order) {
		this.orders.getOrders().add(order);
	}

	public Order getOrder(int idInList) {
		return this.orders.getOrders().get(idInList);
	}

	public List<Order> getAllOrders() {
		return this.orders.getOrders();
	}
	
	public List<String> getClientsAndRooms() {
		List<String> clientsAndRooms = new ArrayList<String>();
		DateFormat clientMoveDateFormat = new SimpleDateFormat("MM/dd/yy");
		for (Order o : this.orders.getOrders()) {
			List<Client> clients = o.getClients();
			Collections.sort(clients, new ClientsNameComparator());
			for (Client c : clients) {
				StringBuilder sb = new StringBuilder();
				sb.append(c.getName());
				sb.append(" Room ¹" + o.getRoom().getRoomId());
				sb.append(" until " + clientMoveDateFormat.format(o.getDateEnd()));
				clientsAndRooms.add(sb.toString());
				//System.out.println(c.getName() + " Room ¹" + o.getRoom().getRoomId() + " " + 
				//		clientMoveDateFormat.format(o.getDateEnd()));
			}
		}
		return clientsAndRooms;
	}
	
	/* returns difference between dateEnd and dateStart in days */ 
	public long calcStayingDays(Order o) {
		long stayingDays = o.getDateEnd().getTime() - o.getDateStart().getTime();
	    return TimeUnit.DAYS.convert(stayingDays, TimeUnit.MILLISECONDS);
	}
	
	/* returns price for staying in room for order o (days * room price) */
	public double calcStayingPrice(Order o) {
		double sum = calcStayingDays(o) * o.getRoom().getPrice();
		return sum;
	}
	
	/* returns price for services used in order o */
	public double calcServicesPrice(Order o)
	{
		double sum = 0;
		for (Service s : o.getServices()) {
			sum += s.getPrice();
		}
		return sum;
	}
	
	/* returns price for order including staying price and services */
	public double calcSumPrice(Order o) {
		return this.calcStayingPrice(o) + this.calcServicesPrice(o);
	}
	
	/* returns list of 3 previous orders for room ¹roomId */ 
	public List<Order> getPreviousRoomers(int roomId) {
		List<Order> prevRoomers= new ArrayList<Order>();
		for (Order o : this.orders.getOrders()) {
			if (o.getRoom().getRoomId() == roomId) {
				prevRoomers.add(o);
			}
			if (prevRoomers.size() == 3) {
				break;
			}
		}
		return prevRoomers;
	}
	
	/* returns list of services for client sorted by price*/
	public List<Service> getClientServices(Client client) {
		List<Service> clientServ = new ArrayList<Service>();
		for (Order o : this.orders.getOrders()) {
			if (o.getClients().contains(client)) {
				clientServ.addAll(o.getServices());
			}
		}
		Collections.sort(clientServ, new ServicesPriceComparator());;
		return clientServ;
	}

}
