public class WordRunner
{
	public static void main(String[] args)
	{
		Word one = new Word("chicken");
		System.out.println(one);
		System.out.println("num vowels == " + one.getNumVowels());
		System.out.println("num chars == " + one.getLength());
		
		one.setWord("alligator");
		System.out.println("\n\n" + one);
		System.out.println("num vowels == " + one.getNumVowels());
		System.out.println("num chars == " + one.getLength());
		
		one.setWord("elephant");
		System.out.println("\n\n" + one);
		System.out.println("num vowels == " + one.getNumVowels());
		System.out.println("num chars == " + one.getLength());
	}
}