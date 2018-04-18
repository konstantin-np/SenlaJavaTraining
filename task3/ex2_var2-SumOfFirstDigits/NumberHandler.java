import java.util.Random;

public final class NumberHandler 
{
	private static Random rnd = new Random();
	
	private NumberHandler()
	{

	}
	
	public static int generateNumber()
	{
		return rnd.nextInt(899) + 100;
	}
	
	public static int getFirstDigit(int n)
	{
		if (n > 99 && n < 1000)
		{
			return n / 100;
		}
		else
		{
			return 0;
		}
	}
	
}
