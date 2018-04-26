import java.util.Comparator;

public class Room {
    
	private int roomId;
    private int capacity; //maximum count of people in room
    private int starsCount;
    private double price;
    private RoomStatus status;
    //private List<Client> roomers;
    
    public Room(int roomId, int capacity, int starsCount, double price) {
		this.roomId = roomId;
		this.capacity = capacity;
		this.starsCount = starsCount;
		this.price = price;
		this.status = RoomStatus.free;
		//this.roomers = new ArrayList<Client>(); 
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

	public static Comparator<Room> StarsCountComparator = new Comparator<Room>() {
		 
        @Override
        public int compare(Room r1, Room r2) {
            return (int) (r1.getStarsCount() - r2.getStarsCount());
        }
    };
    
    public static Comparator<Room> PriceComparator = new Comparator<Room>() {
		 
        @Override
        public int compare(Room r1, Room r2) {
            return (int) (r2.getPrice() - r1.getPrice());
        }
    };
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("¹ " + this.roomId);
    	sb.append(", Capacity: " + this.capacity);
    	sb.append(", " + this.starsCount + " stars");
    	sb.append(", price: " + this.price);
    	sb.append(", status: " + this.status.name());
    	return sb.toString();
    }
	
    /*public List<Client> getRoomers() {
		return roomers;
	}

	public void setRoomers(List<Client> roomers) {
		this.roomers = roomers;
	}
    
	public void addRoomer(Client roomer)
	{
		if (this.roomers.size() + 1 <= this.capacity) {
			this.roomers.add(roomer);
		} else {
			System.out.println("Room is full!");
		}
		
	}
    
	public void removeRoomer(Client roomer)
	{
		this.roomers.remove(roomer);
	}*/
	
}
