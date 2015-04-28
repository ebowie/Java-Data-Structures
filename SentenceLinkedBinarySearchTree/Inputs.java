import java.util.*;
import java.io.*;
/**
 *  this class has all the user function that the user picked in the driver class this puts through the
 *  results 
 * 
 * @author (Eric Bowers ) 
 * @version (06/18/2013)
 */
public class Inputs 
{
    Scanner input = new Scanner(System.in);
    
    /**
 * This method shows deletion of occurences in a word and if there is not occurences to be deleted then the word is removed from the tree 
 * 
 * @param( takes in the LinkedBinarySearchTree<Word>) 
 * 
 */public void setdeleteOccurences(LinkedBinarySearchTree<Word> tree)
    {
        Word remove, word, detally;//creating a object from the word class 
        int count;
        
        System.out.println("what word do you want to decrease its occurences"); // asking the user what word she want decrease the count 
        word = new Word(input.next().toUpperCase()); // make sure the word has the right address compare to the other words 
               
               detally =tree.find(word); // this decrease the count of the word occurences 
               
               detally.setDetally(); // this decreases it 
                
               count = detally.getDetally();// and then it puts the number in count 
        if(count == 0)// if the count is zero then the word is removed from the tree 
        {
            remove = tree.removeElement(word);
            System.out.println("The deletion of the occurences cause the word to be removed");// telling the user what happen
        }
        else
        {
            System.out.println("One of the occurences has be deleted from a word");// telling the user what happen 
        }
    }
    
    
    
     /**
 * This method shows the deletion of a word that user want to remove from the tree 
 * 
 * @param( takes in the LinkedBinarySearchTree<Word>) 
 * 
 */public void setdeleteWord(LinkedBinarySearchTree<Word> tree)
    {  Word remove, word, findWord; // creating object from word 
        int count =0;
        
        
       
       
        System.out.println("what word do u want to remove");//asking the user what word to remove
        word = new Word(input.next().toUpperCase()); // checking on the address of the word to be compared and to make sure its the right addresss 
        
        remove = tree.removeElement(word);// puting the word in to the word object 
        
        
        
        
          
        
               System.out.println(remove +"  "+remove.getTally());// showing what word got deleted 
               System.out.println("instead of removing the occurences you removed "+// printing message to the user telling what happen 
                 " the word from the tree");
                
      }
    
    
    
     /**
 * This method shows  that it will print the max from the binary tree 
 * 
 * @param( takes in the LinkedBinarySearchTree<Word>) 
 * 
 */public void setPrintMax(LinkedBinarySearchTree<Word> tree)
    {
       Word max; //creating object from word 
      max= tree.findMax(); // find the max to print the word 
      System.out.println(max);
        
    }
    
     /**
 * This method shows that it will print the min from the binary tree 
 * 
 * @param( takes in the LinkedBinarySearchTree<Word>) 
 * 
 */public void setPrintMin(LinkedBinarySearchTree<Word> tree)
    {  Word min;// creating object from the word 
       min = tree.findMin(); // find min from the tree 
        System.out.println(min);
    }
    
  
    
     /**
 * This method shows the ascending order of the word and occurences of the words and to be put in a nother file 
 * 
 * @param( takes in the LinkedBinarySearchTree<Word>) 
 * 
 */public void setPrintInOrderList(LinkedBinarySearchTree<Word> tree) throws IOException
    {
        PrintWriter outputfile = new PrintWriter("sentenceInOrder.txt");//inputins the ascending order of words in the this file 
         Iterator it = tree.iteratorInOrder();// going through a iterator to print out the word and occurences 
     while(it.hasNext())
     {
       Word tempWord = (Word) it.next();// casting the it.next to put in the word object 
         
         System.out.println(tempWord.getWord()+" "+ tempWord.getTally()+"\n\n" );// print the word out in console 
         outputfile.println(tempWord.getWord()+" "+ tempWord.getTally());// print the word out in the file 
      }
      outputfile.close();// closing the file 
    }
    
    
    
 
    
    
}
