public class Product 
{
	protected String name;
	protected String firm;
	protected double weight;
	
	public Product(String name, String firm, double weight) {
		this.name = name;
		this.firm = firm;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(". Firm: " + this.firm);
		sb.append(". Characteristics: ");
		sb.append(weight + " kg");
		return sb.toString();
	}
}
