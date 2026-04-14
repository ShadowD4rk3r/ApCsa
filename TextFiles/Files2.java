/* Write a program that reads a series of integers from a file
 *  and calculates their sum.  If the sum ever becomes negative,
 *  the program should end, printing off the value of the sum and
 *  the number of steps it took to find the negative value.  If
 *  the sum remains positive, the program should state that there
 *  was no negatiev sum found. 
 */

import java.io.File;
import java.util.Scanner;

public class Files2 {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of the file to read: ");
        String fileName = input.nextLine();
        File file = new File(fileName);

        Scanner fileReader = new Scanner(file);

        int sum = 0;
        int steps = 0;
        boolean becameNegative = false;

        while (fileReader.hasNextInt()) {
            int num = fileReader.nextInt();

            sum += num;
            steps++;

            if (sum < 0) {
                becameNegative = true;
                break;
            }
        }

        fileReader.close();
        input.close();

        if (becameNegative) {
            System.out.println("Sum became negative!");
            System.out.println("Final sum: " + sum);
            System.out.println("Steps taken: " + steps);
        } else {
            System.out.println("No negative sum was found.");
            System.out.println("Final sum: " + sum);
        }
    }
}