public class Plane
{
	private String name;
	private String firm;
	
	public Plane(String n, String f)
	{
		name = n;
		firm = f;
		System.out.println("Plane constructor in action");
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setFirm(String f)
	{
		firm = f;
	}
	
	public String getFirm()
	{
		return firm;
	}
	
}