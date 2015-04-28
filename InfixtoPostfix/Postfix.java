/**
 *  @author Lewis and Chase
 *
 *  Demonstrates the use of a stack to evaluate postfix expressions.
 */
import java.util.Scanner;

public class Postfix    
{
  /**
   * Reads and evaluates multiple postfix expressions.
   */
  public static void main (String[] args)
  {
    String expression, again;
    int result;
    String infix;
    String postfix;
    try
    {
      Scanner in = new Scanner(System.in);
      
      do
      {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        System.out.println ("Enter a infix: "); // enter infix to get the post fix 
        infix = in.nextLine(); // its goes through the scanner 
        InfixToPostFixConverter myConverter = new InfixToPostFixConverter(infix); // tranfers to the converter
         myConverter.setInfix(infix);// set the converter
         postfix = myConverter.getPostfix(); // returns the post fix
        
         // this starts to evaluate it 
        expression = postfix;

        result = evaluator.evaluate (expression);
        System.out.println();
        System.out.println ("That expression equals " + result);

        System.out.print ("Evaluate another expression [Y/N]? ");
        again = in.nextLine();
        System.out.println();
      }
      while (again.equalsIgnoreCase("y"));
    }
    catch (Exception IOException)
	{
	  System.out.println("Input exception reported");
    }
  }
}
