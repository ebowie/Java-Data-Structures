
/**
 * BinarySearchTreeADT method headers
 * 
 * @author (Eric Bowers ) 
 * @version (06/18/2013)
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> 
{
  
   /**
* Adds the specified element to the proper location in this tree.
*
* @param element the element to be added to this tree
*/public void addElement (T element);
   
   /**
* Removes and returns the specified element from this tree.
*
* @param targetElement the element to be removed from this tree
* @return the element removed from this tree
*/public T removeElement (T targetElement);

   /**
* Removes all occurrences of the specified element from this tree.
*
* @param targetElement the element that the list will have all instances
* of it removed
*/public void removeAllOccurrences (T targetElement);

   /**
* Removes and returns the smallest element from this tree.
*
* @return the smallest element from this tree.
*/public T removeMin();
   
   /**
* Removes and returns the largest element from this tree.
*
* @return the largest element from this tree
*/public T removeMax();
  
   /**
* Returns a reference to the smallest element in this tree.
*
* @return a reference to the smallest element in this tree
*/public T findMin();
   
   /**
* Returns a reference to the largest element in this tree.
*
* @return a reference to the largest element in this tree
*/public T findMax();
   
   /**
* Returns true if the binary tree contains an element that matches
* the specified element and false otherwise.
*
* @param targetElement the element being sought in the tree
* @return true if the tree contains the target element
*/ public boolean contains (T targetElement);
   
   
   
   
   
   /**
* Returns a reference to the specified target element if it is
* found in this binary tree. Throws a NoSuchElementException if
* the specified target element is not found in the binary tree.
*
* @param targetElement the element being sought in this tree
* @return a reference to the specified target
* @throws ElementNotFoundException if an element not found exception
occurs
*/public T find (T targetElement);
    
    
   
}  // interface BinarySearchTreeADT

