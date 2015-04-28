import java.util.*;
/**
 * This programs takes a infix and converts it in to postfix 
 * 
 * @author (Eric Bowers ) 
 * @version (June 3 2013)
 */
public class InfixToPostFixConverter
{  // varables for the operators
   /** constant for addition symbol */
  private final char ADD = '+';
  /** constant for subtraction symbol */
  private final char SUBTRACT = '-';
  /** constant for multiplication symbol */
  private final char MULTIPLY = '*';
  /** constant for division symbol */
  private final char DIVIDE = '/';
  /** the stack */
  // create the object of arraystack
  private ArrayStack<Character> stack = new ArrayStack<Character>();
  
  private String infix; // infix varable 
  private String postfix=""; // post fix variable
  // left and right para varables 
  private final char RIGHT_PARA = ')'; 
  private final char LEFT_PARA = '(';
  // precedence rule varables 
  private int precLeft;
  private int precRight;
  // extra varibles
  private char charTemp;
  private String captured;
 
  
  /**
 * 
 * this is a contuctor that take in one string, which is the infix
 * 
 * 
 */public InfixToPostFixConverter(String infix)
  {
      infix = infix;
    }
    
    /**
 * 
 * 
 * this is the setter and it takes in the infix as well 
 * 
 */public void setInfix(String infix)
    {
       // seperating the infix operations
        StringTokenizer token = new StringTokenizer(infix);
        
        while(token.hasMoreTokens())
        {
            // input in char at a time for the switch statement
            charTemp= token.nextToken().charAt(0);
            
            switch(charTemp)
             {
              case LEFT_PARA:stack.push(charTemp);// automaticly gets pushed
                       break;
              case RIGHT_PARA:getSuperPop(); // gets super pop which everything will be poped out 
                       break;
              case MULTIPLY:
              case DIVIDE: setCompareTo(charTemp); // goes to to the compare to method where it will be decide where it should be placed
                       break;
              case SUBTRACT: 
              case ADD: setCompareTo(charTemp);// goes to to the compare to method where it will be decide where it should be placed
                       break; 
              default:postfix += charTemp + " ";// this is to tell if it a number in the infix so it will automaticly go to the postfix
             }
             
             // this is last method to use to when everything else is done you will pop the rest of the stack out 
            if(!token.hasMoreTokens())
            {
                getSuperPop();
                
            }
            
            
        }
        System.out.println("PostFix:"+postfix); // this will display the entire postfix equation
        
       
    }
    
   /**
 * this is another setter that compare if the stack is empyt or not and where to put the operator at  
 * 
 * 
 * 
 */ public void setCompareTo(char useOperator)
    {
        // this checks to see if the stack is empty 
        if(stack.isEmpty())
        {
            
           stack.push(useOperator); // if it is empyt the operator gets pushed 
            
            
        }
        else if(!stack.isEmpty()) // this is when the stack is not empty
        {   
            precLeft=getPrecedence(stack.peek());// this will check anoher method that has switch statment in it to find the the number to compare the operator too
            precRight=getPrecedence(useOperator); //this will check anoher method that has switch statment in it to find the the number to compare the operator too
            
            if(precLeft >= precRight)// this checks to see which operator is higher
              {
                 if(stack.peek()!= '(') // if it is a left para it will exit the if statement and pop it out some where elses
                 {
                  
                  postfix += stack.pop() + " ";// if the there is not a  left para then it will pop the operator in the postfix 
                  if(!stack.isEmpty())// if the stack is not empty still and need to be compared with another operator then it will check to see if the operator are equal or not 
                  {
                  precLeft=getPrecedence(stack.peek());
                  if(precLeft==precRight)
                  {
                   postfix += stack.pop() + " ";// if the operators are equal then it will pop it out stack 
                   
                   stack.push(useOperator);// and push the new operator in it 
                   }
                }   
                  else
                  {
                  stack.push(useOperator);  // the if the  operator is less then in the stack then it will be pushed in the stack
                  }   
                  
                }
                else
                {
                    captured += stack.pop(); // this is where left para is stored 
                    stack.push(useOperator); // then a different operator is pushed
                      
                }
             
               
              
            
         
        }
        else
                  {
                  stack.push(useOperator);  // the if the  operator is less then in the stack then it will be pushed in the stack
                  }   
        
        
    }
}
    // this method is use for to give each operator a number on how great of value they are in the order of operations
   /**
 * 
 *  this a getter that can return what each value the operator has when it will be compared too
 * 
 * 
 */ public int getPrecedence(char PrecOperator)
    {
        int prec=0;
        
        switch(PrecOperator)
             {
              case LEFT_PARA:
              
              case RIGHT_PARA: prec =3;
                       break;
              case MULTIPLY:
              case DIVIDE: prec =2;
                       break;
              case SUBTRACT: 
              case ADD: prec=1;
                       break;
                     
             }
            
            return prec;
            
            
   }
       // the super pop is design to pop every operator out until it is empty from the stack then it will stop
      /**
 * 
 * this is a super pop that allows everything to be pop depending the on the method or operator is being called 
 * 
 *
 */public void getSuperPop() 
      {
        char topStack; 
         while(!stack.isEmpty())// this while goes through until it is empty or there is left paraths
         {  topStack = stack.peek();
            
             if(topStack != '(')
            { 
             
           
         postfix += stack.pop() + " ";
        }
        else
        {
            captured += stack.pop();
         }
        
         
          
        }
       
        
        
    
    }
    
    /**
 *  this getter is returning the postfix to the driver postfix 
 *
 * 
 * 
 */ String getPostfix()// this will send the results back to the driver to be evaluated 
    {
        return postfix;
    } 
}