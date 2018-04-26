
public class Service implements Comparable<Service>{
	
	private String name;
	private double price;
	
	public Service(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int compareTo(Service otherServ) {
		return Double.compare(this.price, otherServ.getPrice());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(", price: " + this.price);
		return sb.toString();
	}
}
