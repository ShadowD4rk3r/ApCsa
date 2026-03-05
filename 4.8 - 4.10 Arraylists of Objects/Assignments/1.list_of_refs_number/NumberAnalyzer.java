import java.util.ArrayList;

public class NumberAnalyzer
{
    private final ArrayList<Number> list;
    public NumberAnalyzer(int[] nums)
    {
        list = new ArrayList<>();

        for(int n : nums)
        {
            list.add(new Number(n));
        }
    }

    // count odds
    public int countOdds()
    {
        int count = 0;

        for(Number n : list)
        {
            if(n.isOdd())
                count++;
        }

        return count;
    }

    // count evens
    public int countEvens()
    {
        int count = 0;

        for(Number n : list)
        {
            if(n.isEven())
                count++;
        }

        return count;
    }

    // count perfect numbers
    public int countPerfects()
    {
        int count = 0;

        for(Number n : list)
        {
            if(n.isPerfect())
                count++;
        }

        return count;
    }

    // toString
    @Override
    public String toString()
    {
        return list.toString();
    }
}