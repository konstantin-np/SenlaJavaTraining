import java.util.ArrayList;
import java.util.List;

public class Flight
{
	private String name;
	private String from;
	private String to;
	private Plane plane;
	private List<Pilot> pilots;
	
	public Flight(String n, String from, String to)
	{
		this.name = n;
		this.from = from;
		this.to = to;
		pilots = new ArrayList<Pilot>();
		System.out.println("Flight constructor in action");
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setFrom(String f)
	{
		from = f;
	}
	
	public String getFrom()
	{
		return from;
	}
	
	public void setTo(String to)
	{
		this.to = to;
	}
	
	public String getTo()
	{
		return to;
	}
	
	public void setPlane(Plane p)
	{
		plane = p;
		System.out.printf("Plane %s is set to %s flight%n", p.getName(), this.name);
	}
	
	public Plane getPlane()
	{
		return plane;
	}
	
	public void addPilot(Pilot p)
	{
		pilots.add(p);
		System.out.printf("Pilot %s is set to %s flight%n", p.getName(), this.name);
	}
	
	public void removePilot(Pilot p)
	{
		pilots.remove(p);
		System.out.printf("Pilot %s is not set to %s flight anymore%n", p.getName(), this.name);
	}
	
	public List<Pilot> getPilots()
	{
		return pilots;
	}
}