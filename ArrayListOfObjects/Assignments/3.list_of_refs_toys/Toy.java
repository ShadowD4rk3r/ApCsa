//design and create
//your Toy class
//e
//Use the lab handout
//and sample runner
//code provided
//to help you

public class Toy
{
    private String name = "";
    private int count = 0;

    public Toy(String n)
    {
        name = n;
        count = 1;
    }

    public String getName()
    {
        return name;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int c)
    {
        count = c;
    }

    public String toString()
    {
        return name + " " + count;
    }

}