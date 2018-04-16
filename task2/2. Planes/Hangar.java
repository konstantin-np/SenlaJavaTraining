import java.util.ArrayList;
import java.util.List;

public class Hangar
{
	private int number;
	private List<Plane> planes;
	
	public Hangar(int n)
	{
		number = n;
		planes = new ArrayList<Plane>();
		System.out.println("Hangar constructor in action");
	}
	
	public void setNumber(int n)
	{
		number = n;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void addPlane(Plane p)
	{
		planes.add(p);
		System.out.printf("Plane %s is stored in hangar ¹%d now%n", p.getName(), this.number);
	}
	
	public void removePlane(Plane p)
	{
		planes.remove(p);
		System.out.printf("Plane %s is not in hangar ¹%d anymore%n", p.getName(), this.number);
	}
	
	public List<Plane> getPlanes()
	{
		return planes;
	}
}
