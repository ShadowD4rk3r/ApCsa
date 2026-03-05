public class NumberAnalyzerRunner
{
    public static void main(String[] args)
    {
        int[] r = {5, 12, 9, 6, 1, 4, 8, 6 };
        NumberAnalyzer test = new NumberAnalyzer( r );
        System.out.println(test);
        System.out.println("odd count = "+test.countOdds());
        System.out.println("even count = "+test.countEvens());
        System.out.println("perfect count = "+test.countPerfects()+"\n\n\n");

        int[] r2 = {5, 12, 3, 7, 28, 496, 81, 65, 33, 11};
        NumberAnalyzer test2 = new NumberAnalyzer(r2);

        System.out.println(test2);
        System.out.println("odd count = " + test2.countOdds());
        System.out.println("even count = " + test2.countEvens());
        System.out.println("perfect count = " + test2.countPerfects() + "\n\n\n");
    }
}