import java.util.*;
import java.io.*;
/**
 * driver2 is to go through the linked list orderlist to put 19000 word in order.
 * 
 * @author (Eric Bowers ) 
 * @version (6/9/2013)
 */
public class driver2
{
  public static void main(String [] args) throws IOException
  {
   
     int index =0;// this is for the index  element for the array 
     String line; // to put the 19000 words in the string 
    OrderedLinkedList[] myListArray = new OrderedLinkedList[26]; // object array of 26 orders lists
    File myfile= new File("word.txt"); // the file of 19000 words being tranfers to myfile
    Scanner input =new Scanner(myfile); // the myfile being transfer to a scanner method varible 
    
    double timeStart = System.currentTimeMillis();// the starting of the time in milliseconds 
    // iteratoring through the list of 26 objects 
    for(int i =0; i<26; i++)
    {
       myListArray[i]= new  OrderedLinkedList();
        
    }
   
    // using the while loop to put each word throught add method
    while(input.hasNext())
    {   
        line = input.nextLine();// from line to line
        index=line.charAt(0) - 'A'; // using ascii to determine what index the word should be in 
       
        
        myListArray[index].add(line);// letting the word go through the add method 
        
        
    }
    // using the for loop to diaplay all 19000 words 
     for(int i =0;i<26;i++)
     {
      System.out.print(myListArray[i].toString());   
      
      }
    double timeStop = System.currentTimeMillis();// ending the time limt
    System.out.println("\n\nMlliseconds elapsed:" + (timeStop - timeStart));// displaying the time 
      input.close();
  }
}
