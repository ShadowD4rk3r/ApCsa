public class Word
{
   private static final String vowels = "AEIOUaeiou";       // Constant for vowel letters (case-insensitive)
                     
   private String word = "";
   public Word (String w)
   {
       word = w;
   }
   
   public int getNumVowels()
   {
       int count = 0;
       for (int i = 0; i < word.length(); i++)
       {
           if (vowels.indexOf(word.charAt(i)) != -1)
           {
               count++;
           }
       }
       return count;
   }

   public int getLength()
   {
       return word.length();
   }

   // allow the stored word to change
   public void setWord(String w)
   {
       word = w;
   }

   // print the word when the object is used in string context
   public String toString()
   {
       return word;
   }

}
