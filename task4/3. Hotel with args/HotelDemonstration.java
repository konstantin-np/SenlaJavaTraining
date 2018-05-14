import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import models.*;
import models.hotelroom.*;
import stores.*;
import services.*;

public class HotelDemonstration {
	public static void main(String[] args) {
		
		ClientsStore clients = new ClientsStore();
		ServicesStore services = new ServicesStore();
		RoomsStore rooms = new RoomsStore();
		OrdersStore orders = new OrdersStore();
		
		ClientsManipulator clientsManipul = new ClientsManipulator();
		RoomsManipulator roomsManipul = new RoomsManipulator();
		OrdersManipulator ordersManipul = new OrdersManipulator();
		
		//clients
		String clientName1 = "Ivanov A.G.";
		String clientName2 = "Petrova I.P.";
		String clientName3 = "Sidorov A.B.";
		String clientName4 = "Sezonov D.P.";
		Client guestIvanov = new Client(clientName1, 54098989);
		Client guestPetrova = new Client(clientName2, 57098876);
		Client guestSidorov = new Client(clientName3, 54323568);
		Client guestSezonov = new Client(clientName4, 54324957);
		clients.addClient(guestIvanov);
		clients.addClient(guestSezonov);
		clients.addClient(guestSidorov);
		clients.addClient(guestPetrova);
		
		//rooms
		int roomId1 = 1;
		int roomId2 = 2;
		int roomId3 = 3;
		int roomId4 = 4;
		Room room1 = new Room(roomId1, 1, 4, 2000);
		Room room2 = new Room(roomId2, 2, 3, 1900);
		Room room3 = new Room(roomId3, 3, 5, 2500);
		Room room4 = new Room(roomId4, 2, 4, 2300);
		rooms.addRoom(room1);
		rooms.addRoom(room2);
		rooms.addRoom(room3);
		rooms.addRoom(room4);
		
		//services
		Service serviceDrinks = new Service("Cold drinks", 15.5);
		Service serviceFood = new Service("Food", 65.8);
		services.addService(serviceDrinks);
		services.addService(serviceFood);
		
		//orders
		Order order1 = new Order(clients.getClient(0), rooms.getRoomById(roomId1));
		Order order2 = new Order(clients.getClient(2), rooms.getRoomById(roomId2));
		order2.addClient(clients.getClient(1));
		//adding start and end dates to orders 
		DateFormat clientMoveDateFormat = new SimpleDateFormat("MM/dd/yy");
		try {
			order1.setDateStart(clientMoveDateFormat.parse("4/26/2018"));
			order1.setDateEnd(clientMoveDateFormat.parse("4/28/2018"));
			
			order2.setDateStart(clientMoveDateFormat.parse("4/25/2018"));
			order2.setDateEnd(clientMoveDateFormat.parse("5/03/2018"));
			
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		orders.addOrder(order1);
		orders.addOrder(order2);
		
		//change room status to "onRepair"
		rooms.getRoomById(roomId3).setStatus(RoomStatus.onRepair);
		
		//get list of all rooms at hotel
		List<Room> allRooms = roomsManipul.getRoomsList(rooms);
		System.out.println("All rooms: ");
		for (Room r : allRooms) {
			System.out.println(r.toString());
		}
		
		//get list of free rooms at hotel
		List<Room> freeRooms = roomsManipul.getFreeRooms(rooms);
		System.out.printf("%nFree rooms: %n");
		for (Room r : freeRooms) {
			System.out.println(r.toString());
		}
		
		//get list of clients and their rooms
		List<String> clientsWithRooms = ordersManipul.getClientsAndRooms(orders);
		System.out.printf("%nClients and their rooms: %n");
		for (String s : clientsWithRooms) {
			System.out.println(s);
		}
		
		//get count of free rooms at the moment
		int freeRoomsCount = roomsManipul.getFreeRoomsCount(rooms);
		System.out.printf("Count of free rooms is %d%n", freeRoomsCount);
		
		
		//get current count of clients
		int clientsCount = clientsManipul.getClientsCount(clients);
		System.out.printf("Count of clients is %d%n", clientsCount);
		
		//get list of room that will be free at date 5/12/2018
		Date freeRoomsDate;
		try {
			freeRoomsDate = clientMoveDateFormat.parse("5/12/2018");
			List<Room> roomsFreeAtDate = roomsManipul.getRoomsFreeAtDate(rooms, orders, freeRoomsDate);
			System.out.printf("%nFree rooms at %s: %n", freeRoomsDate.toString());
			for (Room r : roomsFreeAtDate) {
				System.out.println(r.toString());
			}
		}
		catch (Exception e) {
			System.out.println("Can not parse date for free rooms");
		}
		
		//get order price for staying at room including services for client
		orders.getOrder(0).addService(services.getService(0));
		double price = ordersManipul.calcSumPrice(orders.getOrder(0));
		System.out.printf("Price for order *** %s *** is %.2f", orders.getOrder(0), price);
		
		//get 3 previous roomers of room ¹1
		//set some clients for this room and remove them three times
		rooms.getRoomById(roomId1).setStatus(RoomStatus.free);
		Order orderRoom1 = new Order(clients.getClient(1), rooms.getRoomById(roomId1));
		try {
			orderRoom1.setDateStart(clientMoveDateFormat.parse("4/29/2018"));
			orderRoom1.setDateEnd(clientMoveDateFormat.parse("5/02/2018"));
		}
		catch (Exception e) {
			System.out.println("Can not parse dates for order room #1");
		}
		orders.addOrder(orderRoom1);
		
		rooms.getRoomById(roomId1).setStatus(RoomStatus.free);
		orderRoom1 = new Order(clients.getClient(3), rooms.getRoomById(roomId1));
		try {
			orderRoom1.setDateStart(clientMoveDateFormat.parse("5/03/2018"));
			orderRoom1.setDateEnd(clientMoveDateFormat.parse("5/05/2018"));
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		orders.addOrder(orderRoom1);
		
		rooms.getRoomById(roomId1).setStatus(RoomStatus.free);
		orderRoom1 = new Order(clients.getClient(0), rooms.getRoomById(roomId1));
		try {
			orderRoom1.setDateStart(clientMoveDateFormat.parse("5/06/2018"));
			orderRoom1.setDateEnd(clientMoveDateFormat.parse("5/10/2018"));
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		orderRoom1.addService(serviceFood);
		orderRoom1.addService(serviceDrinks);
		orders.addOrder(orderRoom1);
			
		List<Order> prevRoomers = ordersManipul.getPreviousRoomers(orders, roomId1);
		System.out.printf("%n%nPrevious roomers of room ¹%d:%n", roomId1);
		
		for (Order o : prevRoomers) {
			StringBuilder prevRoomersString = new StringBuilder();
			for (int i = 0; i < o.getClients().size(); i++) {
				prevRoomersString.append(o.getClients().get(i).getName() + " ");
			}
			prevRoomersString.append(clientMoveDateFormat.format(o.getDateStart()) + " - ");
			prevRoomersString.append(clientMoveDateFormat.format(o.getDateEnd()));
			System.out.println(prevRoomersString.toString());
		}
		
		//get list of services for client
		List<Service> clientServices = ordersManipul.getClientServices(orders, clients.getClient(0));
		System.out.printf("%nServices of client %s:%n", clients.getClient(0).getName());
		for (Service s : clientServices) {
			System.out.println(s.toString());
		}
		
		String filepath;
		if (args.length > 0) {
			filepath = args[0]; 
		} else {
			filepath = "roomsdata.txt";
		}
		//writing rooms data to file
		roomsManipul.writeRoomsDataToFile(rooms, filepath);
		//reading rooms data from file
		List<Room> roomsFromFile = roomsManipul.readRoomsDataFromFile(filepath);
		for (Room r : roomsFromFile) {
			System.out.println(r.toString());
		}
		
	}
}
