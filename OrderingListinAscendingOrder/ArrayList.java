
import java.util.Iterator;
public abstract class ArrayList<T> implements ListADT<T>, Iterable<T>
{
   protected int count; // count the list 
   public T[] arrayElements; // the array for the list 
   protected int first, last; // first element and last element for the list 
   protected int capacity; // capacity for the list 
   
   
       /**
    * Creates an empty list using the default capacity.
    */public ArrayList() 
   {
       count = 0; // intializing count to zero
        arrayElements = (T[])new Object[100];// puting a 100 objects in the array 
       first = last = 0; // intialzing first and last to zero
       capacity= 100; // making the capacity to zero 
   }
   
   
       /**
    * Creates an empty list using the specified capacity.
    *
    * @param initialCapacity the integer value of the size of the array list
    */public  ArrayList(int intialCapacity)
   {
       count = 0;// intializing count to zero
        arrayElements = (T[])new Object[intialCapacity];// puting a 100 objects in the array 
       first = last = 0;// intialzing first and last to zero
       capacity= intialCapacity;// making the capacity to zero 
       
    }
    
    /**
    * Removes and returns the first element.
    *
    * @param element the element to be removed and returned
    * from the list
    * @return the removed first element
    * @throws ElementNotFoundException if an element not found exception occurs
    */public T removeFirst() throws  EmptyListException
    {
       if(isEmpty()) throw new  EmptyCollectionException("no first element to remove");
       
       T results = arrayElements[first];
       
       for(int i = 0; i<count;i++)
       {
          arrayElements[i] = arrayElements[i+1];
       }
        
       count--;
       last--;
       
       return results;
        
    }
     
    /**
    * Removes and returns the last element.
    *
    * @param element the element to be removed and returned
    * from the list
    * @return the removed last element
    * @throws ElementNotFoundException if an element not found exception occurs
    */public T removeLast() throws EmptyListException
    {
     if(isEmpty()) throw new EmptyCollectionException("no last element to remove");
     
     T results = arrayElements[last];
     
     
     arrayElements[last] = null;
    
     return results;
    }
    
        /**
    * Removes and returns the specified element.
    *
    * @param element the element to be removed and returned
    * from the list
    * @return the removed element
    * @throws ElementNotFoundException if an element not found exception occurs
    */public T remove(T target) throws EmptyCollectionException, ElementNotFoundException
    {
        if(isEmpty()) throw new EmptyCollectionException("nothing to remove");
        
        T results = null;
        boolean found = false;
        int locate = 0;
        
        for(int j = 0; j<count&&found;j++)
        {
            if(arrayElements[j].equals(target))
            {
                found = true;
                results =arrayElements[j];
                locate= j;
            }
        }
        
        
        for(int k = locate; k<count&& found;k++)
        {
            arrayElements[k]=arrayElements[k+1];
        }
        
        count--;
        last--;
        return results;
        
        
    }
    
    /**
    * This method is used to see what is on top of the list .
    *
    * @return take the element and returns the element address to be seen 
    */public T first()
    {
        return arrayElements[first];
    }
    
    /**
    * This method is used to see what is on bottom of the list .
    *
    * @return take the element and returns the element address to be seen 
    */public T last()
    {
        return arrayElements[last];
    }
    
    /**
    * This method is used to see what is on specific target of the list .
    * @param target is what element you want to put in there to see the address 
    * @return take the element and returns the element address to be see if it is true or false
    */public boolean contains( T target)
    {
        for(int i = 0;i<count;i++)
        {
            if(arrayElements[i].equals(target))
            {
              return true;
            } 
            
            
        }
        return false;
    }
    
    /**
    * This method is used to see if the list is empty .
    *
    * @return check to see if it true or false if the list is empty 
    */public boolean isEmpty()
    {
        return (count == 0);
    }
    
    /**
    * This method is used to see how big the list is .
    *
    * @return take the element and return number of how large the list is 
    */public int size()
    {
        return count;
    }
    
        /**
    * Returns an iterator for the elements currently in this list.
    *
    * @return an iterator for the elements in this list
    */
    public Iterator<T> iterator()
    {
    return new ArrayIterator<T> (arrayElements, count);
    }
    
    /**
    * This method is used to display the elements of the a list .
    *
    * @return take the element and display it on the console 
    */public String toString()
    {
        String results ="  ";
        for(int i =0; i<count; i++)
        {
            results+=arrayElements[i];
           
        }   
         return results;
    }
    
}