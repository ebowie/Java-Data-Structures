    //****************************************************************
    //  LinkedIterator.java       Authors: Lewis/Chase
    //
    //  Represents an iterator for a linked list of linear nodes.
    //****************************************************************
    
   
    import java.util.*;
    
    public class LinkedIterator<T> implements Iterator
    {
       private int count;  // the number of elements in the collection
       private LinearNode<T> current;  // the current position
    
       //-------------------------------------------------------------
       //  Sets up this iterator using the specified items.
       //-------------------------------------------------------------
       /**
* Sets up this iterator using the specified items.
*
* @param collection the collection the iterator will move over
* @param size the integer size of the collection
*/public LinkedIterator (LinearNode<T> collection, int size)
       {
          current = collection;
          count = size;
       }
    
       //-------------------------------------------------------------
       //  Returns true if this iterator has at least one more element
       //  to deliver in the iteraion.
       //-------------------------------------------------------------
       /**
* Returns true if this iterator has at least one more element
* to deliver in the iteration.
*
* @return true if this iterator has a least one more element to deliver
* in the iteration
*/public boolean hasNext()
       {
          return count != 0;
       }
    
       //-------------------------------------------------------------
       //  Returns the next element in the iteration. If there are no
       //  more elements in this itertion, a NoSuchElementException is
       //  thrown.
       //-------------------------------------------------------------
       /**
* Returns the next element in the iteration. If there are no
* more elements in this iteration, a NoSuchElementException is
* thrown.
*
* @return the next element in the iteration
* @throws NoSuchElementException if a no such element exception occurs
*/public T next()
       {
          if (count == 0)
             throw new NoSuchElementException();
    
          T result = current.getElement();
          current = current.getNext();
          count --;
          return result;
       }
    
       //-------------------------------------------------------------
       //  The remove operation is not supported.
       //-------------------------------------------------------------
       /**
* The remove operation is not supported.
*
* @throws UnsupportedOperationException if an unsupported operation
* exception occurs
*/public void remove() throws UnsupportedOperationException
       {
          throw new UnsupportedOperationException();
       }
    }

