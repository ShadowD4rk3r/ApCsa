import java.util.*;

public class ToyStoreRunner
{
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner n = new Scanner(System.in);

		ToyStore sto = new ToyStore();
		System.out.println( sto );
		String[] s = "sorry bat sorry sorry sorry train train teddy teddy ball ball".split(" ");
		sto.loadToys( s );
		System.out.println( sto );	
		System.out.println( "max == " + sto.getMostFrequentToy() );	
		System.out.println( sto.getThatToy( sto.getMostFrequentToy() ) );	
		
		System.out.println(" ");

		ToyStore sto2 = new ToyStore();
		System.out.println( sto2 );
		String[] s2 = n.nextLine().trim().split("\\s+");
		sto2.loadToys( s2 );
		System.out.println( sto2 );
		System.out.println("max == " + sto2.getMostFrequentToy());
		String max = sto2.getMostFrequentToy();
		System.out.println(sto2.getThatToy( max ));
	}
}