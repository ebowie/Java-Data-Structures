public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>
{
    
   
   
   /**
    * Creates an empty list using the default capacity.
    */public ArrayUnorderedList()
    {
      super();// geting information from arraylist  
        
    }
   
    
    /**
     * Creates an empty list using the specified capacity.
     */public ArrayUnorderedList(int x)
    {
      super(x);// geting information from arraylist  
        
      
    }
    
    
    /**
     *  Adds the specified element to the front of the list.
     */public void addToFront( T element)
    {
        if (size() == arrayElements.length)
         expandCapacity();

     
      for (int scan=count; scan > 0; scan--)
         arrayElements[scan] = arrayElements[scan-1];

      arrayElements[0] = element;
      count++;
    }
    
    /**
     * Adds the specified element to the rear of the list.
     */public void addToRear ( T element)
    {
     if (size() == arrayElements.length)
         expandCapacity();

      arrayElements[count] = element;
      count++;
        
    }
    
    
   /**
    * Adds the specified element after the specified target element.
   //  Throws a ElementNotFoundException if the target is not found.
    */public void addAfter (T element, T target)
   {
      if (size() == arrayElements.length)
         expandCapacity();

      int scan = 0;
      while (scan < count && !target.equals(arrayElements[scan])) 
          scan++;
      
      if (scan == count)
         throw new ElementNotFoundException ("no list is shown");
    
      scan++;
      for (int scan2=count; scan2 > scan; scan2--)
         arrayElements[scan2] = arrayElements[scan2-1];

      arrayElements[scan] = element;
      count++;
   }
    
    /**
    * using another array to expand the capacity of the orginal array 
    * 
    *
    * @param taking the array list and expanding the index capacity 
    */public void expandCapacity()
    {
        T[] TempArray=(T[])new Object[capacity *2]; // declaring the array and expanding it 
        
        // iteratoring through the expanded array and puting it the orginal array
        for(int i =0; i<capacity;i++)
            {
                TempArray[i] = arrayElements[i];
                
                arrayElements= TempArray;
                
            }
    }
   

}

