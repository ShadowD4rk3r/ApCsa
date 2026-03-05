import java.util.*;

public class Words
{
	private ArrayList<Word> words;

	public Words(String[] wordList)
	{
		words = new ArrayList<>();

		for (String w : wordList)
		{
			words.add(new Word(w));
		}
	}

	public int countWordsWithXChars(int size)
	{
		int count = 0;

		for (Word w : words)
		{
			if (w.getLength() == size) 
			{
				count++;
			}
		}
		return count;
	}
	
	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{
		int vowelSum = 0;

		Iterator<Word> it = words.iterator();

		while (it.hasNext())
		{
			Word w = it.next();

			if (w.getLength() == size)
			{
				vowelSum += w.getNumVowels();
				it.remove();
			}
		}

		return vowelSum;
	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count = 0;

		for(Word w : words)
		{
			if(w.getNumVowels() == numVowels)
				count++;
		}

		return count;
	}
	
	public String toString()
	{
		return words.toString();
	}
	
}