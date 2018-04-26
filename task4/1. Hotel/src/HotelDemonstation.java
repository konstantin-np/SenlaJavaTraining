import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HotelDemonstation {

	public static void main(String[] args) {
		Hotel hotel = new Hotel("VazaPlaza");
		
		int roomId1 = 1;
		int roomId2 = 2;
		int roomId3 = 3;
		int roomId4 = 4;
		
		Room room1 = new Room(roomId1, 1, 4, 2000);
		Room room2 = new Room(roomId2, 2, 3, 1900);
		Room room3 = new Room(roomId3, 3, 5, 2500);
		Room room4 = new Room(roomId4, 2, 4, 2300);
		
		hotel.addRoom(room1);
		hotel.addRoom(room2);
		hotel.addRoom(room3);
		hotel.addRoom(room4);
		
		String clientName1 = "Ivanov A.G.";
		String clientName2 = "Petrova I.P.";
		String clientName3 = "Sidorov A.B.";
		String clientName4 = "Sezonov D.P.";
		
		Client guestIvanov = new Client(clientName1, 54098989);
		Client guestPetrova = new Client(clientName2, 57098876);
		Client guestSidorov = new Client(clientName3, 54323568);
		Client guestSezonov = new Client(clientName4, 54324957);
		
		/*hotel.addClient(guestIvanov);
		hotel.addClient(guestPetrova);
		hotel.addClient(guestSidorov);
		hotel.addClient(guestSezonov);*/
			
		Service serviceDrinks = new Service("Cold drinks", 15.5);
		Service serviceFood = new Service("Food", 65.8);
		
		hotel.addSerivce(serviceDrinks);
		hotel.addSerivce(serviceFood);
		
		hotel.addOrder(new Order(guestIvanov, hotel.getRoomByRoomId(roomId1)));
		Order orderTwo = new Order(guestPetrova, hotel.getRoomByRoomId(roomId2));
		orderTwo.addClient(guestSidorov);
		hotel.addOrder(orderTwo);
		
		
		DateFormat clientMoveDateFormat = new SimpleDateFormat("MM/dd/yy");
		try {
			Order or = hotel.getOrders().get(0);
			or.setDateStart(clientMoveDateFormat.parse("4/26/2018"));
			or.setDateEnd(clientMoveDateFormat.parse("4/28/2018"));
			
			or = hotel.getOrders().get(1);
			or.setDateStart(clientMoveDateFormat.parse("4/25/2018"));
			or.setDateEnd(clientMoveDateFormat.parse("5/03/2018"));
			
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		
		hotel.getRoomByRoomId(roomId3).setStatus(RoomStatus.onRepair);
		
		List<Room> rooms = hotel.getRooms();
		System.out.println("All rooms: ");
		for (Room r : rooms) {
			System.out.println(r.toString());
		}
		
		rooms = hotel.getFreeRooms();
		System.out.printf("%nFree rooms: %n");
		for (Room r : rooms) {
			System.out.println(r.toString());
		}
		
		List<Order> orders = hotel.getOrders();
		Collections.sort(orders);
		System.out.printf("%nClients and their rooms: %n");
		for (Order o : orders) {
			for (Client c : o.getClients()) {
				System.out.println(c.getName() + " Room ¹" + o.getRoom().getRoomId() + " " + 
						clientMoveDateFormat.format(o.getDateEnd()));
			}
		}
		
		Date freeRoomsDate;
		try {
			freeRoomsDate = clientMoveDateFormat.parse("5/12/2018");
		}
		catch (Exception e) {
			System.out.println("Can not parse date");
			freeRoomsDate = null;
		}
		List<Room> roomsFreeAtDate = hotel.getRoomsFreeAtDate(freeRoomsDate);
		System.out.printf("%nFree rooms at %s: %n", freeRoomsDate.toString());
		for (Room r : roomsFreeAtDate) {
			System.out.println(r.toString());
		}
		
		int guestsCount = hotel.getGuestsCount();
		System.out.printf("%nCurrent count of guests: %d%n", guestsCount);
		int freeRoomsCount = hotel.getFreeRoomsCount();
		System.out.printf("Current count of free rooms: %d%n",  freeRoomsCount);
		
		//test three previous roomers of room 1
		
		hotel.getRoomByRoomId(roomId1).setStatus(RoomStatus.free);
		Order orderRoom1 = new Order(guestPetrova, hotel.getRoomByRoomId(roomId1));
		try {
			orderRoom1.setDateStart(clientMoveDateFormat.parse("4/29/2018"));
			orderRoom1.setDateEnd(clientMoveDateFormat.parse("5/02/2018"));
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		hotel.addOrder(orderRoom1);
		
		hotel.getRoomByRoomId(roomId1).setStatus(RoomStatus.free);
		orderRoom1 = new Order(guestSezonov, hotel.getRoomByRoomId(roomId1));
		try {
			orderRoom1.setDateStart(clientMoveDateFormat.parse("5/03/2018"));
			orderRoom1.setDateEnd(clientMoveDateFormat.parse("5/05/2018"));
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		hotel.addOrder(orderRoom1);
		
		hotel.getRoomByRoomId(roomId1).setStatus(RoomStatus.free);
		orderRoom1 = new Order(guestIvanov, hotel.getRoomByRoomId(roomId1));
		try {
			orderRoom1.setDateStart(clientMoveDateFormat.parse("5/06/2018"));
			orderRoom1.setDateEnd(clientMoveDateFormat.parse("5/10/2018"));
		}
		catch (Exception e) {
			System.out.println("Can not parse dates");
		}
		orderRoom1.addService(serviceFood);
		orderRoom1.addService(serviceDrinks);
		hotel.addOrder(orderRoom1);
			
		List<Order> prevRoomers = hotel.getPreviousRoomers(roomId1);
		System.out.printf("%nPrevious roomers of room ¹%d:%n", roomId1);
		
		for (Order o : prevRoomers) {
			StringBuilder prevRoomersString = new StringBuilder();
			for (int i = 0; i < o.getClients().size(); i++) {
				prevRoomersString.append(o.getClients().get(i).getName() + " ");
			}
			prevRoomersString.append(clientMoveDateFormat.format(o.getDateStart()) + " - ");
			prevRoomersString.append(clientMoveDateFormat.format(o.getDateEnd()));
			System.out.println(prevRoomersString.toString());
		}
		

		List<Service> guestServices = hotel.getClientServices(guestIvanov);
		System.out.printf("%nServices of client %s:%n", guestIvanov.name);
		for (Service s : guestServices) {
			System.out.println(s.toString());
		}
		
		double price = hotel.getOrders().get(hotel.getOrders().size() - 1).calcSumPrice();
		System.out.printf("%nPrice for order: %.2f%n%n", price);
		
		for (Order o : hotel.getOrders()) {
			System.out.println(o.toString());
		}
		
		hotel.writeOrdersDataToFile("orders.txt");
		
		System.out.println("Hotel is closed!");
	}

}
