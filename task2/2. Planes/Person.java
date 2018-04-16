import java.util.Date;

public class Person
{
	protected String name;
	protected Date birthDate;

	public Person(String n)
	{
		name = n;
		//birthDate = bd;
		System.out.println("Person constructor in action");
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setBirthDate(Date bd)
	{
		birthDate = bd;
	}
	
	public Date getBrithDate()
	{
		return birthDate;
	}
	
	
}