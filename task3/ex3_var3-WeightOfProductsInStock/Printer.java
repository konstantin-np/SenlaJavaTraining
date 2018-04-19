public class Printer extends Product 
{
	private String typeOfPrinting; //laser, inkjet, ....
	private int printSpeed; //sheets per minute
	
	public Printer(String name, String firm, double weight, String typeOfPrinting, int printSpeed) {
		super(name, firm, weight);
		this.typeOfPrinting = typeOfPrinting;
		this.printSpeed = printSpeed;
	}

	public String getTypeOfPrinting() {
		return typeOfPrinting;
	}

	public void setTypeOfPrinting(String typeOfPrinting) {
		this.typeOfPrinting = typeOfPrinting;
	}

	public int getPrintSpeed() {
		return printSpeed;
	}

	public void setPrintSpeed(int printSpeed) {
		this.printSpeed = printSpeed;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", Printing: " + this.typeOfPrinting);
		sb.append(", Printing speed: " + this.printSpeed + " sheets/min");
		return sb.toString();
	}
}
