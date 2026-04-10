/* Write a program that reads in a series of integers and reports
 *  the total number of numbers, the sum of the numbers, a count
 *  of the even numbers, and the percent of even numbers. * 
 */

import java.io.File;
import java.util.Scanner;

public class Files1
{    public static void main(String[] args) throws Exception
    {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter the name of the file to read: ");
    String fileName = input.nextLine();
    File myObj = new File(fileName);

    input.close();

    while (myObj.hasNextInt())
    {
        int num = myObj.nextInt();
        System.out.println(num);
    }

    /* Use this if you are unsure if it is working, this is helpful. */
    /* 
    Scanner myReader = new Scanner(myObj);
        try 
        {
        

        //System.out.println("File name: " + myObj.nextLine());
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        System.out.println("Writeable: " + myObj.canWrite());
        System.out.println("Readable " + myObj.canRead());
        System.out.println("File size in bytes " + myObj.length());
        } 
        finally 
        {
            myReader.close();
        } 
    */


    }
}