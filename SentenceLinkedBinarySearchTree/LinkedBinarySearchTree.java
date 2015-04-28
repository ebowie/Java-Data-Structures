


/**
 * this is LinkedBinarySearchTree with method that will allow you to do certain things in the tree 
 * 
 * @author (Eric Bowers ) 
 * @version (06/18/2013)
 */public class LinkedBinarySearchTree<T>  extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

   //================================================================

   //================================================================
   /**
    * Creates an empty binary search tree.
    */public LinkedBinarySearchTree() 
   {
      super();
   }  // constructor BinarySearchTree

   //================================================================
   
   //================================================================
   /**
    *  Creates a binary search with the specified element as its
   //  root.
    */public LinkedBinarySearchTree (T element) 
   {
      super (element);
   }  // constructor BinarySearchTree

  
   /**
* Adds the specified element to the proper location in this tree.
*
* @param element the element to be added to this tree
*/public void addElement (T element) 
   {
      T testing = element;
      BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
      Comparable<T> comparableElement = (Comparable<T>)element;

      if (isEmpty())
         root = temp;
      else 
      {
         BinaryTreeNode<T> current = root;
         boolean added = false;

         while (!added) 
         {
            if (comparableElement.compareTo(current.element) < 0)

               if (current.left == null) 
               {
                  current.left = temp;
                  added = true;
               } 
               else
                  current = current.left;
            else
               if (current.right == null) 
               {
                  current.right = temp;
                  added = true;
               } 
               else
                  current = current.right;
         }//while
      }//else

      count++;

   }  // method addElement

   //================================================================
  
   //================================================================
   /**
* Removes and returns the specified element from this tree.
*
* @param targetElement the element to be removed from this tree
* @return the element removed from this tree
*/public T removeElement (T targetElement) throws ElementNotFoundException 
   { 

      T result = null;

      if (!isEmpty())

         if (((Comparable)targetElement).equals(root.element)) 
         {
            result =  root.element;
            root = replacement (root);
            count--;
         } //if
        else 
        {
            BinaryTreeNode<T> current, parent = root;
            boolean found = false;

            if (((Comparable)targetElement).compareTo(root.element) < 0)
               current = root.left;
            else
               current = root.right;

            while (current != null && !found) 
            {
               if (targetElement.equals(current.element)) 
               {
                  found = true;
                  count--;
                  result =  current.element;
          
                  if (current == parent.left)
                  {
                     parent.left = replacement (current);
                  }
                  else
                  {
                     parent.right = replacement (current);
                  }
               } //if
              else 
              {
                  parent = current;
         
                  if (((Comparable)targetElement).compareTo(current.element) < 0)
                     current = current.left;
                  else
                     current = current.right;
               } //else
            } //while
            if (!found)
               throw new ElementNotFoundException("binary tree");
         } //else

      return result;

   }  // method removeElement

   //================================================================
  
   //================================================================
   /**
* Removes all occurrences of the specified element from this tree.
*
* @param targetElement the element that the list will have all instances
* of it removed
*/public void removeAllOccurrences (T targetElement) throws
   ElementNotFoundException 
   {
     removeElement(targetElement);
     
     try
        {
            while( contains( (T) targetElement))
            removeElement(targetElement);
        }
        catch(Exception ElementNotFoundException)
        {
        }
         
   }  // method removeAllOccurrences

   //================================================================
  
   //================================================================
   /**
* Removes and returns the smallest element from this tree.
*
* @return the smallest element from this tree.
*/public T removeMin() throws EmptyCollectionException 
   {
       T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree is empty");
      else 
      {
         if (root.left== null) 
         {
            result = root.element;
            root = root.right;
         } //if
         else 
         {
            BinaryTreeNode<T> parent = root;
            BinaryTreeNode<T> current = root.left;
            while (current.left != null) 
            {
               parent = current;
               current = current.left;
            } //while
            result =  current.element;
            parent.left = current.right;
         } //else

         count--;
      } //else
 
      return result;

   }
       
      //================================================================
   
   //================================================================
   /**
* Removes and returns the largest element from this tree.
*
* @return the largest element from this tree
*/public T removeMax() throws EmptyCollectionException 
   {
      T result = null;

      if (isEmpty())
           throw new EmptyCollectionException ("binary tree is empty");
      else 
      {
         if (root.right == null) 
         {
            result =  root.element;
            root = root.left;
         } //if
         else 
         {
              BinaryTreeNode<T> parent = root;
              BinaryTreeNode<T> current = root.right;

              while (current.right != null) 
              {
                 parent = current;
                 current = current.right;
              } //while

              result =  current.element;
              parent.right= current.left;
           } //else

         count--;
      } //else

      return result;
   }  // method removeMax

   //================================================================
   
   //================================================================
   /**
* Returns a reference to the smallest element in this tree.
*
* @return a reference to the smallest element in this tree
*/public T findMin() throws EmptyCollectionException 
   {if (root == null){throw new EmptyCollectionException("no data in tree");}
     BinaryTreeNode<T> current = root;
     BinaryTreeNode<T> parent = null;
     if (root.left == null)
       return root.element;
     else {
         parent = root;
         current = root.left;
         while (current.left != null) 
         {
            parent = current;
            current = current.left;
         }//while
         return current.element;
        }//else
   }  // method findMin

   //================================================================
   
   //================================================================
   /**
* Returns a reference to the largest element in this tree.
*
* @return a reference to the largest element in this tree
*/public T findMax() throws EmptyCollectionException 
     {if (root == null){throw new EmptyCollectionException("no data in tree");}
     BinaryTreeNode<T> current = root;
     BinaryTreeNode<T> parent = null;
     if (root.right == null)
       return root.element;
     else {
         parent = root;
         current = root.right;
         while (current.right != null) 
         {
            parent = current;
            current = current.right;
         }//while
         return current.element;
        }//else

   }  // method findMax

   //================================================================
   
   //================================================================
   public T find (T targetElement) throws ElementNotFoundException 
   {
      
    
      T result = null;
     
      boolean found=false;
       BinaryTreeNode<T> temp = root;
      Comparable compareTarget = (Comparable)targetElement; 
       
       
       if(!isEmpty())
       {
           if(compareTarget.equals(root.element))
           {
               result = root.element;
               
           }
           else 
            {
                
                if(compareTarget.compareTo(root.element)<0)
                   {
                       temp = root.left;
                       
                   }
                   else
                    {
                     temp = root.right;   
                     
                    }
                 while(temp != null && !found)
                 {
                   if(compareTarget.equals(temp.element))
                   {
                       result = temp.element;
                       found = true;
                    }
                    else
                    {
                      if(compareTarget.compareTo(temp.element) < 0)
                      {
                          temp = temp.left;
                          
                          
                      }
                      else
                      {
                        temp = temp.right;
                          
                       }
                 
                    
                    }
                    }       
                     
                   
           
        }
    }
    
    
   
    return result;
         } //else

     
       //================================================================
 
   //================================================================
  /**
   * Returns a reference to the specified target element if it is
   //  found in the binary tree.  Throws a NoSuchElementException if
   //  the specified target element is not found in the binary tree.
   */ public boolean contains (T targetElement) 
   {
       boolean found = false;
       
       BinaryTreeNode<T> temp = root;
        if(!isEmpty())
        {
            
      Comparable<T> compareTarget = (Comparable<T>)targetElement; 
       
       
           if(compareTarget.equals(root.element))
           {
               found = true;
               
            }
            else
            {
                
                if(compareTarget.compareTo(root.element)<0)
                   {
                       temp = root.left;
                       
                   }
                   else
                    {
                     temp = root.right;   
                     
                    }
                 while(temp != null && !found)
                 {
                   if(compareTarget.equals(temp.element))
                   {
                       
                       found = true;
                    }
                    else
                    
                      if(compareTarget.compareTo(temp.element)<0)
                      {
                          temp = temp.left;
                          
                          
                        }
                        else
                        {
                        
                        temp = temp.right;
                          
                        }
                        
                 
                    
                       
                       
                     
                   
           
        }
       

      

     // method contains
}
 }
    

return found;


}
   //================================================================
  
   //================================================================
   /**
    * Returns a reference to a node that will replace the one
   //  specified for removal.  In the case where the removed
   //  node has two children, the inorder successor is used
   //  as its replacement.
    */protected BinaryTreeNode<T> replacement (BinaryTreeNode<T> node) 
   {
      BinaryTreeNode<T> result = null;

      if ((node.left == null)&&(node.right==null))
            result = null;
      else if ((node.left != null)&&(node.right==null))
            result = node.left;
      else if ((node.left == null)&&(node.right != null))
            result = node.right;
      else
      {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null) 
            {
               parent = current;
               current = current.left;
            }//while

            if (node.right == current)
               current.left = node.left;
            else
            {
               parent.left = current.right;
               current.right = node.right;
               current.left = node.left;
            }
            result = current;
      }//else
      return result;


   }  // method replacement
}  // class BinarySearchTree 
       
   