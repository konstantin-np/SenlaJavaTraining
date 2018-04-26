import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.senla.training.TextFileWorker;

public class Hotel {
    
	private String name;
	private List<Room> rooms;
	private List<Service> services;
	//private List<Client> clients;
	private List<Order> orders;
	
	public Hotel(String name) {
		this.name = name;
		this.rooms = new ArrayList<Room>();
		this.services = new ArrayList<Service>();
		//this.clients = new ArrayList<Client>();
		this.orders = new ArrayList<Order>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/* returns rooms list sorted by price */
	public List<Room> getRooms() {
		List<Room> allRooms = new ArrayList<Room>(this.rooms);
		allRooms.sort(Room.PriceComparator);
		return allRooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room room) {
		this.rooms.add(room);
	}
	
	public void removeRoom(Room room) {
		this.rooms.remove(room);
	}
	
	/* Returns list of rooms with status "free" sorted by stars count */
	public List<Room> getFreeRooms() {
		List<Room> freeRooms = new ArrayList<Room>();
		for (int i = 0; i < this.rooms.size(); i++) {
			if (this.rooms.get(i).getStatus() == RoomStatus.free) {
				freeRooms.add(this.rooms.get(i));
			}
		}
		freeRooms.sort(Room.StarsCountComparator);
		return freeRooms;
	}
	
	public Room getRoomByRoomId(int id) {
		for (int i = 0; i < this.rooms.size(); i++) {
			if (this.rooms.get(i).getRoomId() == id) {
				return this.rooms.get(i);
			}
		}
		return null;
	}
	
	public Room getRoomByIdInRoomList(int i)
	{
		return this.rooms.get(i);
	}
	
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	public void addSerivce(Service service) {
		this.services.add(service);
	}
	
	public void removeService(Service service) {
		this.services.remove(service);
	}
	
	
	/*public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Client getClientByName(String name) {
		for (int i = 0; i < this.clients.size(); i++) {
			if (this.clients.get(i).getName().equals(name)) {
				return this.clients.get(i);
			}
		}
		return null;
	}
	
	public Client getClientByIdInClientList(int id) {
		return this.clients.get(id);
	}
	
	public void addClient(Client client) {
		this.clients.add(client);
	}
	
	public void removeClient(Client client) {
		this.clients.remove(client);
	}
	
	*/
	public List<Order> getOrders() {
		return this.orders;
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
	
	public int getFreeRoomsCount() {
		int count = 0;
		for (Room r : this.rooms) {
			if (r.getStatus() == RoomStatus.free) {
				count++;
			}
		}
		return count;
	}
	
	public int getGuestsCount() {
		int count = 0;
		for (Order o : this.orders) {
			count += o.getClients().size();
		}
		return count;
	}
	
	public List<Room> getRoomsFreeAtDate(Date d) {
		List<Room> freeRooms = this.getFreeRooms();
		for (Order o : this.orders) {
			if (o.getDateEnd().before(d)) {
				freeRooms.add(o.getRoom());
			}
		}
		return freeRooms;
	}
	
	public List<Order> getPreviousRoomers(int roomId) {
		List<Order> prevRoomers= new ArrayList<Order>();
		for (Order o : this.orders) {
			if (o.getRoom().getRoomId() == roomId) {
				prevRoomers.add(o);
			}
			if (prevRoomers.size() == 3) {
				break;
			}
		}
		return prevRoomers;
	}
	
	public List<Service> getClientServices(Client client) {
		List<Service> clientServ = new ArrayList<Service>();
		for (Order o : this.orders) {
			if (o.getClients().contains(client)) {
				clientServ.addAll(o.getServices());
			}
		}
		return clientServ;
	}
	
	public void writeOrdersDataToFile(String filepath) {
		TextFileWorker tfw = new TextFileWorker(filepath);
		String ordersData[] = new String[this.orders.size()];
		for (int i = 0; i < this.orders.size(); i++) {
			ordersData[i] = this.orders.get(i).toString();
		}
		tfw.writeToFile(ordersData);
	}
	
}
