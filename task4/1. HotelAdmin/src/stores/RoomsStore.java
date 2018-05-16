package stores;

import java.util.ArrayList;
import java.util.List;

import models.hotelroom.Room;

public class RoomsStore implements IRoomsStore {
	
	private List<Room> rooms;
	
	public RoomsStore() {
		rooms = new ArrayList<Room>();
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
}
