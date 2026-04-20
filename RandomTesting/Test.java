import java.util.List;

public class Test {
    /**
     * Determines whether an element of the list contains a previous element of the list
     * @param list the list of strings to check
     * @return true if any element contains a previous element, false otherwise
     */
    public static boolean containsPreviousElement(List<String> list) {
        if (list == null || list.size() < 2) {
            return false;
        }
        
        for (int i = 1; i < list.size(); i++) {
            String current = list.get(i);
            for (int j = 0; j < i; j++) {
                String previous = list.get(j);
                if (current.contains(previous)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether any adjacent pair of strings in the list contains the other.
     * @param wordList the list of strings to check
     * @return true if any adjacent pair contains one another, false otherwise
     */
    public static boolean containsAdjacentPair(List<String> wordList) 
    {
	boolean change = false;

	for (int i = 0; i < wordList.size(); i++)
    {
    	if (wordList.get(i + 1).contains(wordList.get(i)))
        {
        	change = true;
        }
        else 
        {
        	change = false;
            break;
        }
        
        return change;
    }
    
}
}
