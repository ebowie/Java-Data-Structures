import java.util.*;
import java.io.*;
/**
 * this is a hashing program that counts how many collestion it has in the array and a how many empty slots it has.
 * note: the console takes a while to display about three mins or so 
 *  
 * @author (Eric Bowers) 
 * @version (6/26/2013)
 */
public class Driver
{
   public static void main(String [] args) throws IOException
   {
      File myfile = new File("words.txt");// this file of the words 
      
      Scanner inputFile = new Scanner(myfile); // file goes into the scanner 
      
      int[] hash = new int[35625];// this is the array of 80 % factor and how many slot there are 
      
      int number =0; // 
      
      int collestionCount=0;// counts the collestions 
      int emptyCount=0; // counts the empty slots 
      
      //this takes the array fills in the zero for all the slots 
      for(int i=0;i<35625;i++)
      {
         hash[i] = 0; 
          
      }
      
      // this shows the line of each word 
      while(inputFile.hasNext())
      {
          String line;
          int j = 0;
          double numbers = 0;
          int arrayNumber=0;
          line = inputFile.nextLine();// each word goes in the string of the line variable 
          // this goes through the linkes of the words characters
          for(int i = 0; i<line.length();i++)
          {
             if(line.charAt(i) != '-')// this checks to see if there are dashs
             {
                   if(line.charAt(i)!= ' ')// this checkes to see there are any spaces in the length 
                    {
                  numbers += Math.pow(line.charAt(i) - 'a'+1,2);// this take the acsii number from char a and subtracts the data and takes it to the power of 2 for each character number 
                    }
                    else
                    {
                        break;
                    }
              }
           
          }
            
            // this checks if any character goes over array 
            if(numbers > 35625)
            {
             numbers%=35625;   
            }
            
            // this hashes the collestions to be spread out more 
            arrayNumber = (int)numbers;
            int k =0;
             while( k<35625)
             {
              if(hash[k]>0)
              {
                arrayNumber += k;
                  
               }
               
              k++;
            }
            
            // this hashes the collestions to be spread out more
           int l =0;
             while( l<35625)
             {
              if(hash[l]>0)
              {
                arrayNumber += l;
                  
               }
               
              l++;
            }
            // this hashes the collestions to be spread out more
            int m =0;
             while( m<35625)
             {
              if(hash[m]>0)
              {
                arrayNumber += m;
                  
               }
               
              m++;
            }
           
            // this checkes the to see if the character go over the array again 
            if(arrayNumber > 35625)
            {
             arrayNumber%=35625;   
            }
            
            hash[arrayNumber] += 1;// this add on to the collestions
            j++;
        }
        
          // its counts how many collestions and empty slots 
      for(int i=0;i<35625;i++)
      {
        if( hash[i] > 1) 
        {
            collestionCount++;
        }
        if(hash[i] == 0)
        {
         emptyCount++;
        }
        

      }
      // show the collestion and empty slots 
     System.out.println("field collestion:"+ collestionCount);
     System.out.println("empty slots:" +  emptyCount);
     
     // show the entire hash 
     for(int k = 0; k<35625;k++)
     {
         
        System.out.println(k+":" + hash[k]);
        }
   }   
    
}
