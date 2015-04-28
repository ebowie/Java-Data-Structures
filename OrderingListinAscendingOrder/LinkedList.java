

//*******************************************************************
//
//      file:  LinkedList.java
//
//*******************************************************************

import java.util.*;

public abstract class LinkedList<T> implements ListADT<T> , Iterable<T>
{

   protected int count;
   protected LinearNode<T> head, tail;

   //===========================================================
   //  Creates an empty list.
   //===========================================================
   /**
* Creates an empty list.
*/public LinkedList() 
   {
      count = 0;
      head = tail = null;
   }  // constructor List

   //===========================================================
   //  Removes the first element in the list and returns a reference
   //  to it.  Throws an EmptyListException if the list is empty.
   //===========================================================
   /**
    * Removes and returns the first element.
    *
    * @param element the element to be removed and returned
    * from the list
    * @return the removed first element
    * @throws ElementNotFoundException if an element not found exception occurs
    */public T removeFirst() throws EmptyListException
   {
       if(count == 0) throw new EmptyCollectionException("In removing first element");
       
       T result = head.getElement();
       head = head.getNext();
       count--;
       if(count == 0)
           tail = null;
       return result;
   } // method removeFirst
   
   //===========================================================
   //  Removes the last element in the list and returns a reference
   //  to it.  Throws an EmptyListException if the list is empty.
   //===========================================================
   /**
    * Removes and returns the last element.
    *
    * @param element the element to be removed and returned
    * from the list
    * @return the removed last element
    * @throws ElementNotFoundException if an element not found exception occurs
    */public T removeLast() throws EmptyCollectionException 
   {
       if(count == 0) throw new EmptyCollectionException("In removing last element");
       
       T result = tail.getElement();
       LinearNode<T> current = head;
       while(current.getNext() != tail && current != null)
       {
           current = current.getNext();
        }
        tail = current;
        current.setNext(null);
        count--;
        if(count == 0)
          head = null;
        return result;

   } // method removeLast
   
   //===========================================================
   //  Removes the first instance of the specified element from the
   //  list if it is found in the list and returns a reference to it.
   //  Throws an EmptyListException if the list is empty.  Throws a
   //  NoSuchElementException if the specified element is not found
   //  on the list.
   //===========================================================
   /**
    * Removes and returns the specified element.
    *
    * @param element the element to be removed and returned
    * from the list
    * @return the removed element
    * @throws ElementNotFoundException if an element not found exception occurs
    */public T remove (T targetElement) throws
   EmptyCollectionException, ElementNotFoundException 
   {

      if (count == 0)
         throw new EmptyCollectionException ("List");

      boolean found = false;

      LinearNode<T> previous = null;
      LinearNode<T> current = head;

      while (current != null && !found) 
         if (targetElement.equals (current.getElement()))
            found = true;
         else {
            previous = current;
            current = current.getNext();
         }

      if (!found)
         throw new ElementNotFoundException ("In removing a target element");

      if (count == 1)
         head = tail = null;
      else if (current == head) 
              head = current.getNext();
           else if (current == tail) 
                {
                   tail = previous;
                   tail.setNext(null);
                } 
                else 
                   previous.setNext(current.getNext());

      count--;

      return current.getElement();

   }  // method remove
   
   //===========================================================
   //  Finds the first instance of the specified element from the
   //  list if it is found in the list and returns true. 
   //  Returns false otherwise                                     
   //===========================================================
  /**
    * This method is used to see what is on specific target of the list .
    * @param target is what element you want to put in there to see the address 
    * @return take the element and returns the element address to be see if it is true or false
    */ public boolean contains (T targetElement) 
   {
      boolean found = false;

     
      LinearNode<T> current = head;

      while (current != null && !found) 
         if (targetElement.equals (current.getElement()))
            found = true;
         else 
         {
          
            current = current.getNext();
         }
         
         return found;


   }  // method contains 
   
 
   //===========================================================
   //  Returns true if the list is empty and false otherwise
   //===========================================================
   /**
    * This method is used to see if the list is empty .
    *
    * @return check to see if it true or false if the list is empty 
    */public boolean isEmpty() 
   {
     return (count == 0);
   }
    

   //===========================================================
   //  Returns the number of elements in the list.
   //===========================================================
   /**
    * This method is used to see how big the list is .
    *
    * @return take the element and return number of how large the list is 
    */public int size() 
   {
       return count;
    }  // method size



   //===========================================================
   //  Returns a string representation of the list.
   //===========================================================
   /**
    * This method is used to display the elements of the a list .
    *
    * @return take the element and display it on the console 
    */public String toString() 
   {
    String result = "";
    LinearNode<T> current = head;
    while(current != null)
    {
        result += current.getElement()+ "\n";
        current = current.getNext();
    }
    return result;
   } // method toString

   //===========================================================
   //  Returns ... 
   //===========================================================
     /**
    * Returns an iterator for the elements currently in this list.
    *
    * @return an iterator for the elements in this list
    */public Iterator<T> iterator()
   {
      return new LinkedIterator(head,count); 


    }  // method elements

   //===========================================================
   //  Returns the first element of the list. 
   //===========================================================
   /**
    * This method is used to see what is on top of the list .
    *
    * @return take the element and returns the element address to be seen 
    */public T first() throws EmptyListException
   {
       if(count == 0) throw new EmptyListException("In first");
       return head.getElement();
   }  // method firstElement

   //===========================================================
   //  Returns the last element of the list. 
   //===========================================================
   /**
    * This method is used to see what is on bottom of the list .
    *
    * @return take the element and returns the element address to be seen 
    */public T last() 
   {

   if(count == 0) 
      throw new EmptyCollectionException("Trying to examine last");
  
     return tail.getElement();
   }  // class LinkedList
}

















