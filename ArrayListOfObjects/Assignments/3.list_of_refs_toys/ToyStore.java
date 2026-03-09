import java.util.ArrayList;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList  = new ArrayList<Toy>();
	}

	public void loadToys( String[] toys )
	{
		for (String t : toys)
		{
			t = t.trim().toLowerCase();
			Toy found = getThatToy(t);

			if (found == null)
			{
				toyList.add(new Toy(t));
			}
			else
			{
				found.setCount(found.getCount() + 1);
			}
		}
	}
  
  	public Toy getThatToy( String nm )
  	{
    nm = nm.trim();

		for (Toy t : toyList)
		{
			if (t.getName().trim().equalsIgnoreCase(nm))
			{
				return t;
			}
		}
    return null;
}
  
  	public String getMostFrequentToy()
  	{
		if (toyList.size() == 0)
		{
			return null;
		}

    	Toy max = toyList.get(0);

		for (Toy t : toyList)
		{
			if (t.getCount() > max.getCount())
			{
				max = t;
			}
		}
    	return max.getName();
	}  
  
  	public void sortToysByCount()
  	{
    for (int i = 0; i < toyList.size(); i++)
    {
        for (int j = i + 1; j < toyList.size(); j++)
        {
            if (toyList.get(j).getCount() > toyList.get(i).getCount())
            {
                Toy temp = toyList.get(i);
                toyList.set(i, toyList.get(j));
                toyList.set(j, temp);
            }
        }
    }
}  
  	  
	public String toString()
	{
	   return toyList.toString();
	}
}