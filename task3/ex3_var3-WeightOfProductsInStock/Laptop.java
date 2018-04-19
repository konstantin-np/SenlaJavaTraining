public class Laptop extends Computer 
{
	private String sreenRes;
	private double batteryCapacity; //in hours
	
	public Laptop(String name, String firm, double weight, double cpu, int ram, int cap, int videoRam, String sreenRes,
			double batteryCapacity) 
	{
		super(name, firm, weight, cpu, ram, cap, videoRam);
		this.sreenRes = sreenRes;
		this.batteryCapacity = batteryCapacity;
	}
	
	public String getSreenRes() {
		return sreenRes;
	}
	public void setSreenRes(String sreenRes) {
		this.sreenRes = sreenRes;
	}
	public double getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", Screen resolution: " + this.sreenRes);
		sb.append(", Battery: " + this.batteryCapacity + " hours");
		return sb.toString();
	}
}
