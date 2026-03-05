//write the Number class
//use the handout and
//sample runner code
//to guide you

public class Number
{
    private final int number;
    
    public Number(int num)
    {
        number = num;
    }
    
    public boolean isOdd()
    {
        return number % 2 != 0;
    }
    
    public boolean isPerfect()
    {
        int sum = 0;
        
        for (int i = 1; i < number; i++)
        {
            if ( number % i == 0)
            {
                sum += i;
            }
        }
        
        return sum == number;
    }
    
    public boolean isEven()
    {
        return number % 2 == 0;
    }
    
    @Override
    public String toString()
    {
        return "" + number;
    }
}