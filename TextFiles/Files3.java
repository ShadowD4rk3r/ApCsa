/* Write a program that reads a series of basketball game results.  
 * The file contains results from Women's and Men's games.
 * Each result identifies the type of game it was and the point total.
 * The program should output the numner of Women's games played and their
 *  total points earned, and the number of Men's games played and their 
 *  total points earned.
 */
import java.io.File;
import java.util.Scanner;

public class Files3 {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the file to read: ");
        String fileName = input.nextLine();
        File file = new File(fileName);

        Scanner fileReader = new Scanner(file);

        int womenGames = 0;
        int womenPoints = 0;
        int menGames = 0;
        int menPoints = 0;

        while (fileReader.hasNext()) {
            String type = fileReader.next().toLowerCase();
            int points = fileReader.nextInt();

            if (type.equals("women")) {
                womenGames++;
                womenPoints += points;
            } else if (type.equals("men")) {
                menGames++;
                menPoints += points;
            }
        }

        fileReader.close();
        input.close();

        System.out.println("Women's games: " + womenGames);
        System.out.println("Women's total points: " + womenPoints);
        System.out.println("Men's games: " + menGames);
        System.out.println("Men's total points: " + menPoints);
    }
}