package models;

public class Service {
	
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(", price: " + this.price);
		return sb.toString();
	}
}
