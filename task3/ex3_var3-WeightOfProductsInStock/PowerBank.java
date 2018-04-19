public class PowerBank extends Product 
{
	private int capacity; //mAh
	
	public PowerBank(String name, String firm, double weight, int capacity)
	{
		super(name, firm, weight);
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", " + this.capacity + " mAh");
		return sb.toString();
	}
}
