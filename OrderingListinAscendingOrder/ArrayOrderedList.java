
/**
 * Abstract class ArrayOrderedList -  this ArrayOrderList class has methods for the list data structure to being add o
 * remove and or see what is in side the list.
 * 
 * @author (Eric Bowers)
 * @version (6/9/2013)
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T>
{
    int x;// declaring the for the super method for the super class;
    
    
    
    public ArrayOrderedList(int x)
    {
      super(x);// geting information from arraylist  
        
    }
    
    
      /**
    * Adds the specified Comparable element to this list, keeping
    * the elements in sorted order.
    *
    * @param element the element to be added to this list
    */
    public void add (T element)
    {
       // this is for if there is to many words to expand the array
    if (size() == arrayElements.length)
    expandCapacity();
    Comparable<T> temp = (Comparable<T>)element;// checking each word that is comparable to determine where to put it 
    int scan = 0; 
    // this determine where to put the words at or what word need to be put down a index to enter another in the slot it was in
    while (scan < count && temp.compareTo(arrayElements[scan]) > 0)
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

