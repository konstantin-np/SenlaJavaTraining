package stores;

import java.util.List;

import models.hotelroom.Room;

public interface IRoomsStore {
	public void addRoom(Room room);
	public void removeRoom(Room room);
	public Room getRoomById(int roomId);
	public Room getRoomByIdInList(int idInList);
	public List<Room> getAllRooms();
}
