import java.util.ArrayList;

public class test2
{
    private ArrayList<Integer> temperatures = new ArrayList<Integer>();
    public test2()
    {
        temperatures.add(90);
        temperatures.add(92);
        temperatures.add(95);
        temperatures.add(100);
        temperatures.add(85);
        temperatures.add(92);
        temperatures.add(92);
    }


public int longestHeatWave(int threshold)
{
	int heatWaveDays = 0;
    int temp = 0;
    
    for (int i = 0; i < temperatures.size(); i++)
    {
    	if (temperatures.get(i) > threshold)
        heatWaveDays++;
			if (temperatures.get(i) != temperatures.get(0) && temperatures.get(i - 1) > threshold)
			{
            	heatWaveDays++;
			}
            else 
            {
            	if ( heatWaveDays > temp)
                {
            		temp = heatWaveDays;
            		heatWaveDays = 0;
                }
            }
    }
    
    return (temp > heatWaveDays ? temp : heatWaveDays);
}



    public static void main(String[] args)
    {
        test2 t = new test2();
        System.out.println(t.longestHeatWave(92));
    }
}