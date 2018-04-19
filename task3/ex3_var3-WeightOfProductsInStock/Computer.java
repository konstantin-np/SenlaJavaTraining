public class Computer extends Product 
{
	protected double cpuFrequency;
	protected int ram;
	protected int capacity;
	protected int videoRam;
	
	public Computer(String name, String firm, double weight, double cpu, int ram, int cap, int videoRam)
	{
		super(name, firm, weight);
		this.cpuFrequency = cpu;
		this.ram = ram;
		this.capacity = cap;
		this.videoRam = videoRam;
	}

	public double getCpuFrequency() {
		return cpuFrequency;
	}

	public void setCpuFrequency(double cpuFrequency) {
		this.cpuFrequency = cpuFrequency;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getVideoRam() {
		return videoRam;
	}

	public void setVideoRam(int videoRam) {
		this.videoRam = videoRam;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", " + this.cpuFrequency + " GHz");
		sb.append(", RAM: " + this.ram + " Gb");
		sb.append(", HDD: " + this.capacity + " Gb");
		sb.append(", Video: " + this.videoRam + "Gb");
		return sb.toString();
	}
}
