//********************************************************************
// 
//
//  Represents an array implementation of a stack.
//********************************************************************



public class ArrayStack<T> implements StackADT<T>
{
  private final int DEFAULT_CAPACITY = 100;
  private int top;  // indicates the next open slot
  private transient T[] stack;
  
  /*******************************************************************
    Creates an empty stack using the default capacity.
  *******************************************************************/
  public ArrayStack()
  {
    top = 0;
    stack = (T[])(new Object[DEFAULT_CAPACITY]);
  }

  /*******************************************************************
    Creates an empty stack using the specified capacity.
  *******************************************************************/
  public ArrayStack (int initialCapacity)
  {
    top = 0;
    stack = (T[])(new Object[initialCapacity]);
  }

  /*******************************************************************
    Adds the specified element to the top of this stack, expanding
    the capacity of the stack array if necessary.
  *******************************************************************/
  public void push (T element)
  {
    if (size() == stack.length) 
      expandCapacity();

    stack[top] = element;
    top++;
  }

  /*******************************************************************
    Removes the element at the top of this stack and returns a
    reference to it. Throws an EmptyStackException if the stack
    is empty.
  *******************************************************************/
  public T pop() 
  {
    if (isEmpty())
      throw new EmptyCollectionException("Stack: pop( ) method");

    top--;
    T result = stack[top];
    stack[top] = null; 

    return result;
  }
   
  /*******************************************************************
    Returns a reference to the element at the top of this stack.
    The element is not removed from the stack.  Throws an
    EmptyStackException if the stack is empty.  
  *******************************************************************/
  public T peek()
  {
    if (isEmpty())
      throw new EmptyCollectionException("Stack: peek( ) method");

    return stack[top-1];
  }

  /*******************************************************************
    Returns true if this stack is empty and false otherwise. 
  *******************************************************************/
  public boolean isEmpty()
  {
    return (top == 0);
  }
 
  /*******************************************************************
    Returns the number of elements in this stack.
  *******************************************************************/
  public int size()
  {
    return top;
  }

  /*******************************************************************
    Returns a string representation of this stack. 
  *******************************************************************/
  public String toString()
  {
    String result = "";

    for (int scan=0; scan < top; scan++)
      result = result + stack[scan].toString() + "\n";

    return result;
  }

  /*******************************************************************
    Creates a new array to store the contents of this stack with
    twice the capacity of the old one.
  *******************************************************************/
  private void expandCapacity()
  {
    T[] larger = (T[])(new Object[stack.length*2]);
    
    for (int index=0; index < stack.length; index++)
      larger[index] = stack[index];
    
    stack = larger;
  }
}