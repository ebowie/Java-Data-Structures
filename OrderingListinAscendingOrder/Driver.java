import java.util.*;
import java.io.*;
import java.util.Calendar;
/**
 * This driver is for to display the list of 19000 words and show the list of the 19000 word in orderd. 
 * also it will show that time it takes to display the 19000 words 
 * 
 * @author (Eric Bowers) 
 * @version (6/9/2013)
 */
public class Driver
{
    public static void main(String[] args) throws IOException
    {
        File myfile = new File("word.txt"); // to access the file of the words 
        Scanner input = new Scanner(myfile); // turning the file in to a scanner method 
        ArrayOrderedList<String> Alist = new ArrayOrderedList<String>(19000);// creating a list of 19000 word for it
        double timeStart  = System.currentTimeMillis(); // this beginning count of how long the code with take to go through the console 
        while(input.hasNext()) // to iterate through the strings and display the list of words
        {
            String line;// for all the word to be put in a string 
            
            line =input.nextLine(); // make sure they display through by line by line
            System.out.println(line);// display the list of words 
            Alist.add(line);// this go through the add method for the orderlist
        }
        
        Iterator<String> iterate = Alist.iterator();// is iterator set up for the display order list
        System.out.println("\n\n");
        System.out.println("The is the ArrayOrderList in Ordered");// this seperate from the unorderlist to the orderlist
        System.out.println("\n\n");
        while(iterate.hasNext())
        {
            System.out.println(iterate.next());// this goes through the order list 
            
        }
        double timeStop =System.currentTimeMillis();// the time limit of the code stops right there
        
         System.out.println("\n\nMlliseconds elapsed:" + (timeStop - timeStart)); // this will display the code 
         // this is a if any body miss any code in my ccnsole
          System.out.println("\n\n Make sure you go to the middle of the console"+
                              " to see where the list is put in ordered instead of unordered"
                              +"bascally there are two lists in the console");
                              
            input.close();
    }
    
    
}
