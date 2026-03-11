public class RecursionFunOne
{
    public static int countOddDigits(int num)
    {
        if (num == 0)
        {
            return 0;
        }
        
        int something = ((num % 10) % 2 == 0 ? 1 : 0);

        return something + countOddDigits(num / 10);

    }
}