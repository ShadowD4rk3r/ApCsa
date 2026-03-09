public class WordsRunner
{
	public static void main(String[] args)
	{
		
		String[] wrds = "one two three four five six seven alligator".split(" ");
		Words test = new Words( wrds );
		System.out.println(test);
		System.out.println("word with 2 vowels = "+test.countWordsWithXVowels(2));
		System.out.println("word with 3 vowels = "+test.countWordsWithXVowels(3));
		System.out.println("word with 4 vowels = "+test.countWordsWithXVowels(4));
		System.out.println("word with 2 chars = "+test.countWordsWithXChars(2));
		System.out.println("word with 3 chars = "+test.countWordsWithXChars(3));		
		System.out.println("word with 4 chars = "+test.countWordsWithXChars(4));
		System.out.println("word with 5 chars = "+test.countWordsWithXChars(5));
		int vowelsRemoved = test.removeWordsWithXChars(3);
		System.out.println("\nafter removing words with 3 chars \n" + test);
		System.out.println("\nnumber of vowels in the words removed == " + vowelsRemoved);
		System.out.println("\n\n");		
				
		//add more test cases
	

		String[] wrds2 = "seven eight fivehundred seventeen thechildren fnaflore williamafton god".split(" ");
		Words test2 = new Words(wrds2);
		System.out.println(test2);
		System.out.println("word with 2 vowels = "+test2.countWordsWithXVowels(2));
		System.out.println("word with 3 vowels = "+test2.countWordsWithXVowels(3));
		System.out.println("word with 4 vowels = "+test2.countWordsWithXVowels(4));
		System.out.println("word with 2 chars = "+test2.countWordsWithXChars(2));
		System.out.println("word with 3 chars = "+test2.countWordsWithXChars(3));		
		System.out.println("word with 4 chars = "+test2.countWordsWithXChars(4));
		System.out.println("word with 5 chars = "+test2.countWordsWithXChars(5));
		int vowelsRemoved1 = test2.removeWordsWithXChars(3);
		System.out.println("\nafter removing words with 3 chars \n" + test2);
		System.out.println("\nnumber of vowels in the words removed == " + vowelsRemoved1);
		System.out.println("\n\n");		
				
	}
}