import java.util.List;

public class WordsArray 
{
	private List<String> words;
	
	public WordsArray(List<String> words)
	{
		this.words = words;
	}
	
	public void addWord(String word)
	{
		words.add(word);
	}
	
	public List<String> getWords()
	{
		return words;
	}
	
	public void toUpperCase()
	{
		String word = "";
		for (int i = 0; i < words.size(); i++)
		{
			word = words.get(i);
			words.set(i, word.substring(0, 1).toUpperCase() + word.substring(1));
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.size(); i++)
			sb.append(words.get(i) + " ");
		return sb.toString();
	}
	
}
