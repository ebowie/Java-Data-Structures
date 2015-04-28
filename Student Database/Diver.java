

import java.util.*;
import java.io.*;
import java.util.NoSuchElementException;
/**
 * This example shows you how to create an object using a generic 
 * how to use its compareTo method. In your program, the Student
 * class already has a compareTo method and equals method and the to stringmethof, you just have
 * to call it.
 * 
 * @author Eric Bowers 
 * @version 5/24/2013
 */
public class Diver
{
    public static void main(String [] args) throws IOException
    {
        
       
        String [] stud = new String [11]; // its inputs the 10 students 
        double [] testScores = new double [5]; // it inputs the 5 test scores 
        int num1, num2; // this if for the scanner class
        File myfile  = new File("student.txt"); // creating file object
        Scanner input = new Scanner(myfile); // for the file to go in to the tokenizer
        
        System.out.println("There are 10 Students that have ID's and test averages."+"\n"+
                            "enter 2 Students who you like to compare to and see if they are equal."
                            +"\n"+"enter a Student from 1 through 10");
        Scanner  input2 = new Scanner(System.in);// for user to input the num what student to pick
        
        
        System.out.print("Student#:");
         
        while(input.hasNext())
        {   
            
            String line ;
            StringTokenizer token, token2;// two token for the two student objects
            for(int i = 0; i<11;i++)
            {line = input.nextLine();
             
            
            
            stud[i] = line;//puts each line of the student information in to the array
           
            }
            
            
                num1 =input2.nextInt();
                token = new StringTokenizer(stud[num1],","); // input what number of student you want to use and get it tokenized
                System.out.print("Student#:");
                num2 = input2.nextInt();
                token2 = new StringTokenizer(stud[num2],",");// input in the second student to get tokenized
               
                String name = token.nextToken();// this puts in the name 
                String ID = token.nextToken(); // this puts in the ID
                
                for(int j = 0; j<5; j++)
                {
                 
                  testScores[j]= Double.parseDouble(token.nextToken());  // this puts in the five test scores in the array by for loop
                    
                }
              
              StudentClass myStudInfo = new StudentClass(name,ID,testScores);// this goes through the contructor 
              System.out.println(myStudInfo.toString()); // this dislays the to strings results 
              //////////////////////////////////////////////////////////////////////////
              
              
              ////////////////////////////////////////////////////////////////////////////
              
             
             // the same proces is done again for the second object 
                  
                String name2 = token2.nextToken();
                String ID2=  token2.nextToken();
                
                for(int j = 0; j<5; j++)
                {
                    
                  testScores[j]= Double.parseDouble(token2.nextToken());  
                    
                }
              
              StudentClass myStudInfo2 = new StudentClass(name2,ID2,testScores);
              System.out.println("\n\n"+myStudInfo2.toString());
              
              
              // this compare to method that compare the average of each student
               if (myStudInfo.compareTo(myStudInfo2)> 0)
               System.out.println("\nStudent#:"+num1+" had a better average");
               else if(myStudInfo.compareTo(myStudInfo2)== 0)
               {
                  System.out.println("\nThe averages are the same");
                }
                else
                System.out.println("\nStudent#:"+num2+" had a better average");
               
                
                
                // this is the equal method that see if the ID is equal to a another ID
              if(ID.equals(ID2))
              System.out.println("The Students have matching ID.");
              else
              System.out.println("The Students do NOT have matching  ID");
              
              
               System.out.println(myStudInfo.compareTo(myStudInfo2));// this display if there is a one or -1 or maybe a 0
        }
       
       
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
}