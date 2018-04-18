import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpperCaseDemonstration {

	public static void main(String[] args) 
	{
		WordsArray wordsSeq; 
		List<String> words = new ArrayList<String>();
		String word = "";
		Scanner in = new Scanner(System.in);
		
		do
		{
			System.out.print("Input word (type \"stop\" to stop the input)> ");
			word = in.nextLine();
			words.add(word);
		} while (! word.equals("stop"));
		
		wordsSeq = new WordsArray(words);
		System.out.println(wordsSeq.toString());
		wordsSeq.toUpperCase();
		System.out.println(wordsSeq.toString());
	}

}
