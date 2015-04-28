//*******************************************************************
//
//      LinkedBinaryTree.java           Authors:  Lewis/Chase
//
//     Implements the BinaryTreeADT interface
//*******************************************************************

import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> 
{

   protected int count;
   protected BinaryTreeNode<T> root; 

   //================================================================
   
   //================================================================
   /**
    *  Creates an empty binary tree.
    */public LinkedBinaryTree() 
   {
      count = 0;
      root = null;
   }  // constructor LinkedBinaryTree

   //================================================================
  
   //================================================================
   /**
    * Creates a binary tree with the specified element as its root.
    */public LinkedBinaryTree (T element) 
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }  // constructor LinkedBinaryTree

   //================================================================
   
   //================================================================
   /**
    * Constructs a binary tree from the two specified binary trees.
    */public LinkedBinaryTree (T element, LinkedBinaryTree<T> leftSubtree,
                                 LinkedBinaryTree<T> rightSubtree) 
   {

     root = new BinaryTreeNode<T> (element);
     count = 1;
     if (leftSubtree != null)
     {
        count = count + leftSubtree.size();
        root.left = leftSubtree.root;
     }//if
     else
        root.left = null;
     if (rightSubtree !=null)
     {
        count = count + rightSubtree.size(); 
        root.right = rightSubtree.root;
     }//if
     else
        root.right = null;
 
   }  // constructor LinkedBinaryTree
   
   //================================================================
  
   //================================================================
    /**
* Should be implemented to remove the left subtree of the root
    of the binary tree
*
* @return the integer number of elements in this tree
*/public void removeLeftSubtree() 
   {
      if (root.left != null)
        count = count - root.left.numChildren() - 1;
      root.left = null;
   }  // method removeLeftSubtree

   //================================================================
   
   //================================================================
   /**
* Should be implemented to remove the right subtree of the root
   //  of the binary tree.
*
* @return the integer number of elements in this tree
*/public void removeRightSubtree() 
   {
       if (root.right != null)
       count = count - root.right.numChildren() - 1;
       root.right = null;
}  // method removeRightSubtree
   
   //================================================================
   
   //================================================================
   /**
* Should be implemented to remove all elements from the binary
   //  tree
* @return the integer number of elements in this tree
*/public void removeAllElements() 
   {root = null;
    count = 0;
}  // method removeAllElements
   
   //================================================================
  
   //================================================================
    /**
* Returns true if this binary tree is empty and false otherwise.
*
* @return true if this binary tree is empty
*/ public boolean isEmpty() 
   {return ( count == 0);
}  // method isEmpty

   //================================================================
  
   //================================================================
    /**
* Returns the number of elements in this binary tree.
*
* @return the integer number of elements in this tree
*/public int size() 
  {
    return count;
    }  // method size
   
   //================================================================
  
   //================================================================
   /**
* Returns true if the binary tree contains an element that matches
* the specified element and false otherwise.
*
* @param targetElement the element being sought in the tree
* @return true if the tree contains the target element
*/public boolean contains (T targetElement) 
   {
     BinaryTreeNode<T> temp = findagain( targetElement, root );
     if( temp == null )
       return false;
       else
       return true;
     
}  // method contains

   //================================================================
   
   //================================================================
   /**
* Returns a reference to the specified element if it is found in
* this binary tree. Throws an exception if the specified element
* is not found.
*
* @param targetElement the element being sought in the tree
* @return a reference to the specified element
*/public T find(T targetElement) throws ElementNotFoundException {
     BinaryTreeNode<T> current = findagain( targetElement, root );
     if( current == null )
       throw new ElementNotFoundException("binarytree");
     return (current.element);
   } // method find

   //================================================================
  
   //================================================================
   /**
    * Returns a reference to the specified target element if it is
   //  found in the binary tree.
    */private BinaryTreeNode<T> findagain(T targetElement, BinaryTreeNode<T> next) {
     if (next == null) {
       return null;
     }
     if (next.element.equals(targetElement)) {
       return next;
     }
     BinaryTreeNode<T> temp = findagain(targetElement, next.left);
     if (temp == null) {
       temp = findagain(targetElement, next.right);
     }
     return temp;
   } // method findagain
 

   //================================================================
   
   //================================================================
   /**
* Returns the string representation of the binary tree.
*
* @return a string representation of the binary tree
*/public String toString() 
   {Iterator<T> it = iteratorInOrder();
       String result = "";
       while (it.hasNext())
       result += it.next();
       return result;
}  // method toString

   //================================================================
   
   //================================================================
    /**
* Performs an inorder traversal on this binary tree by calling an
* overloaded, recursive inorder method that starts with the root.
*
* @return an iterator over the elements of this binary tree
*/public Iterator<T> iteratorInOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      inorder (root, templist);
      return templist.iterator();
   }  // method inorder

   //================================================================

   //================================================================
   /**
    *  Performs a recursive inorder traversal.
    */protected void inorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) 
   {

      if (node != null) 
     {
         inorder (node.left, templist);
         templist.addToRear(node.element);
         inorder (node.right, templist);
      }//if

   }  // method inorder

   //================================================================
 
   //================================================================
    /**
* Performs a preorder traversal on this binary tree by calling an
* overloaded, recursive preorder method that starts with the root.
*
* @return an iterator over the elements of this binary tree
*/public Iterator<T> iteratorPreOrder() 
   {
     ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
     preorder(root,templist);
     return templist.iterator();
     
    }  // method preorder

   //================================================================
   
   //================================================================
   
   /**
    *  Performs a recursive preorder traversal.
    */protected void preorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) 
   {
       if(node != null)
       {
           templist.addToRear(node.element);
           preorder(node.left, templist);
           preorder(node.right,templist);
        }
           
           
        }
        
        
        
   //================================================================

   //================================================================
   

   
   /**
* Performs a postorder traversal on this binary tree by calling an
* overloaded, recursive postorder method that starts with the root.
*
* @return an iterator over the elements of this binary tree
*/public Iterator<T> iteratorPostOrder() 
   {
     ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
     postorder(root, templist);
     return templist.iterator();
   }  // method postorder

   //================================================================
   
   //================================================================
   /**
    *    Performs a recursive postorder traversal.
    */protected void postorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) 
   {

        postorder(node.left,templist);
        postorder(node.right,templist);
        templist.addToRear(node.element);

   }  // method postorder

   //================================================================
   
   //================================================================
   /**
    *   Performs a levelorder traversal on the binary tree, using a
   //  templist.
    */public Iterator<T> iteratorLevelOrder() 
   {

      ArrayUnorderedList<T> nodes = new ArrayUnorderedList<T>();
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      BinaryTreeNode<T> current;

      nodes.addToRear (root.element);

      while (! nodes.isEmpty()) 
	 {
         current = (BinaryTreeNode<T>)nodes.removeFirst();

         if (current != null) 
	    {
            templist.addToRear(current.element);
            nodes.addToRear (current.left.element);
            nodes.addToRear (current.right.element);
         }//if
         else
            templist.addToRear(null);
      }//while
      return templist.iterator();
   }  // method levelorder
// class BinaryTree
     
   }  // method preorder

   