public class SumFirstDigitsDemonstration 
{
	public static void main(String[] args) 
	{
		int a, b, c, sum;
		a = NumberHandler.generateNumber();
		b = NumberHandler.generateNumber();
		c = NumberHandler.generateNumber();
		
		sum = NumberHandler.getFirstDigit(a) + NumberHandler.getFirstDigit(b) + NumberHandler.getFirstDigit(c);
		System.out.printf("Generated numbers: %d, %d, %d%n", a, b, c);
		System.out.printf("Sum of first digits is %d%n", sum);
	}
}
