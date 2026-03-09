public class NumberRunner
{
    public static void main(String[] args)
    {
        int[] nums = {7,28,496,1111,199,201,17};

        for(int num : nums)
        {
            Number one = new Number(num);

            if(one.isOdd())
                System.out.println(one + " is odd.");
            else
                System.out.println(one + " is not odd.");

            if(one.isPerfect())
                System.out.println(one + " is perfect.");
            else
                System.out.println(one + " is not perfect.");
        }
    }
}