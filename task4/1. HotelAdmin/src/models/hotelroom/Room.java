package models.hotelroom;

public class Room {
    
	private int roomId;
    private int capacity; //maximum count of people in room
    private int starsCount;
    private double price;
    private RoomStatus status;
    
    
    public Room(int roomId, int capacity, int starsCount, double price) {
		this.roomId = roomId;
		this.capacity = capacity;
		this.starsCount = starsCount;
		this.price = price;
		this.status = RoomStatus.free;
	}
    
    public int getRoomId() {
		return roomId;
	}
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getStarsCount() {
		return starsCount;
	}
	public void setStarsCount(int starsCount) {
		this.starsCount = starsCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("¹ " + this.roomId);
    	sb.append(", Capacity: " + this.capacity);
    	sb.append(", " + this.starsCount + " stars");
    	sb.append(", price: " + this.price);
    	sb.append(", status: " + this.status.name());
    	return sb.toString();
    }
	
}

