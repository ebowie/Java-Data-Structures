import java.util.*;
import java.io.*;
/**
 * This is program that is able to ask you to input a sentence in to a file and will added to a binary tree and then be able see the inorder of the sentences in
 * ascending over with a count that counts the duplicate of the words and puts the number of words have been add.
 * 
 * options are given in the program to change the words or to delete them for user proposes.
 * 
 * @author (Eric Bowers) 
 * @version (6/18/2013)
 */
public class Driver
{
  public static void main(String [] args) throws IOException
  {
     
      String line =" ";// used for file in while loop to go through each word and check through the if statement
      String sentence; // input the sentences us want to go in the first file so the second file come out in ascending
      char playAgain; // using it contunie the program
     do
      {  
      Scanner keyboard = new Scanner(System.in);// to make key board inputs 
      
     
     File myfile = new File("sentence.txt"); // transfering the file in a object
     PrintWriter myfile2 = new PrintWriter (myfile); // transferingthe file in a object to be able write some thing else in it 
     System.out.println("enter a sentences that will be put in the Linked"+
     "BinarySearchTree and be able to perform a number of options: "); // instructions what to write 
      myfile2.println(keyboard.nextLine()); // inputins the sentences to be printed back on the filr 
      myfile2.close(); //closing the file 
     //////////////////////////////////////////////////////
     
     /////////////////////////////////////////////////////
   
     Scanner input = new Scanner(myfile); // looking a the file again to take sentence out and 
     Word temp,findWord; // objects from the word class 
     LinkedBinarySearchTree<Word> tree = new LinkedBinarySearchTree<Word >();  //creating object from the linked binary search tree
     Inputs myInputs= new Inputs(); // object from the inputs class 
     while(input.hasNext())
     {
        
         line = input.next().toUpperCase(); // going through each word and changing it to uppercase;
         temp = new Word(line); // creating the new word so the word will go through the word class 
         if(tree.contains(temp)) // checking to see if the word is already in the tree if not it add to the tree or incremented 
         {   findWord = tree.find(temp);
             findWord.setTally();
         }
         else
         {temp.setWord(line);
          tree.addElement(temp);
         }
         
         
       
     }
    //////////////////////////////////////////////////////////////////////////
    
    
    ///////////////////////////////////////////////////////////////////////
    do
    {  // this a system out that will give you instructions and options to change or delete words from the tree
    System.out.println("\n\nThis is the number options that you will recevie to be able to edit or change the BinarySearchTree\n"
        + "You have Five option to choose from and will able to use them how ever you like.\n"
        + "Enter CASE A : is to Print the InOrder of the senstence  and show how many occurences they are.\n"
        + "Enter CASE B : is to what word is the max of the tree.\n"
        + "Enter CASE C : is to what word is the min of the tree.\n"
        + "Enter CASE D : is if you want to delete a word out the tree.\n"
        + "Enter CASE E : is if you want to delete the occurences from the tree.\n");
        playAgain = keyboard.nextLine().charAt(0);
    ///////////////////////////////////////////////////////////////////////////////////
    
    
    
    /////////////////////////////////////////////////////////////////////////////////
    
     // switch statement to go in the input class to show the results of tree 
       switch(playAgain)
       {
         case'a': myInputs.setPrintInOrderList(tree); // in ordering ascending order of the words 
          break;
        case'b':myInputs.setPrintMax(tree);  // max word 
          break;
        case'c':myInputs.setPrintMin(tree);  // mino word 
          break;
        case'd':myInputs.setdeleteWord(tree); // delete a word 
          break;
           case'e':myInputs.setdeleteOccurences(tree); // delete a occurences 
          break;
         default:System.out.println("you did not pick the right options try again"); // if you didnt pick any options
         
        }
        System.out.println("do you want to see another option?, enter y"); // if want to contunie with the options 
        playAgain = keyboard.nextLine().charAt(0);
        
        
    }while (playAgain == 'y');
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    
    //////////////////////////////////////////////////////////////////////////////////////////
    
    System.out.println("here the results of the what you did with the options"); // printing the results of what you did in those options 
    myInputs.setPrintInOrderList(tree);
    myInputs.setPrintMax(tree);
    myInputs.setPrintMin(tree);
       ///////////////////////////////////////////////////////////////////////
       
       
       //////////////////////////////////////////////////////////////////////
     System.out.println("Do you want to try different method or another sentence in "+ // if you want to start the program over 
     "the BinarySearchTree , enter y:");
     
     playAgain = keyboard.nextLine().charAt(0);
     
    }while(playAgain == 'y' || playAgain == 'Y');
      
      System.out.println("remember there is file that contains Inorder of the binary tree, its called sentenceInOrder.txt");
      
  }
}
