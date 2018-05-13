package comparators;

import java.util.Comparator;

import models.hotelroom.Room;

public class RoomsPriceComparator implements Comparator<Room> {

	public int compare(Room r1, Room r2) {
		if (r1.getPrice() < r2.getPrice()) {
			return -1;
		}
		if (r1.getPrice() > r2.getPrice()) {
			return 1;
		}
		return 0;
	}
	
}
