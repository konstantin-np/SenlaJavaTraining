package comparators;

import java.util.Comparator;

import models.hotelroom.Room;

public class RoomsStarsCountComparator implements Comparator<Room> {

	public int compare(Room r1, Room r2) {
		return r1.getStarsCount() - r2.getStarsCount();
	}
	
}
