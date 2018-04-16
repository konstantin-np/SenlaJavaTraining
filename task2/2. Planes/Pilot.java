import java.util.Date;

public class Pilot extends Person
{
	private String category;
	
	public Pilot(String n)
	{
		super(n);
		System.out.println("Pilot constructor in action");
	}
	
	public void setCategory(String c)
	{
		category = c;
	}
	
	public String getCategory()
	{
		return category;
	}
	
}