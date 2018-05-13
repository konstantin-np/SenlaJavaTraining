package models;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.hotelroom.*;

public class Order{
	
	private List<Client> clients;
	private Room room;
	private Date dateStart;
	private Date dateEnd;
	private List<Service> services;
	
	public Order(Client client, Room room) {
		this.clients = new ArrayList<Client>();
		this.clients.add(client);
		this.room = room;
		room.setStatus(RoomStatus.occupied);
		services = new ArrayList<Service>();
	} 
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		if (room.getStatus() == RoomStatus.free) {
			this.room = room;
			room.setStatus(RoomStatus.occupied);
			if (room.getCapacity() < this.room.getCapacity()) {
				this.clients.clear();
				System.out.println("New room capacity is less! Clients list was cleared");
			}
		} else {
			System.out.println("Room is not free!");
		}
		
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	public void addClient(Client client) {
		if (this.clients.size() + 1 <= this.room.getCapacity()) {
			this.clients.add(client);
		} else {
			System.out.println("Can't add client because room is full!");
		}
	}
	
	public void removeClient(Client client) {
		this.clients.remove(client);
	}
	
	public void addService(Service service) {
		this.services.add(service);
	}
	
	public void removeService(Service service) {
		this.services.remove(service);
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DateFormat startEndDateFormat = new SimpleDateFormat("MM/dd/yy");
		sb.append("Room ¹" + this.room.getRoomId() + ": ");
		for (int i = 0; i < this.getClients().size(); i++)
		{
			sb.append(this.getClients().get(i).getName() + " ");
		}
		sb.append(", " + startEndDateFormat.format(this.dateStart));
		sb.append(" - " + startEndDateFormat.format(this.dateEnd));
		if (this.services.size() > 0) {
			sb.append(" Services:");
			for (int i = 0; i < this.services.size(); i++) {
				sb.append(" " + this.services.get(i).getName());
			}
		}
		//sb.append(", " + this.calcSumPrice());
		return sb.toString();
	}
}