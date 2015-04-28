

 


/**
 * Write a description of class OrderedLinkedList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T>
{
    
    
    /**
    * Adds the specified Comparable element to this list, keeping
    * the elements in sorted order.
    *
    * @param element the element to be added to this list
    */public void add(T element)

    {
        LinearNode<T> nln = new LinearNode<T>(element);
        LinearNode<T> current;
        LinearNode<T> previous=null;
       
        if(count == 0)
        {
            head = tail = nln;
        }
        else //list is not empty
        {
            current = head;
            Comparable<T> newGuy = (Comparable<T>)element;
            while(current != null && newGuy.compareTo(current.getElement()) > 0)
            {
                previous = current;
                current = current.getNext();
            }
            if(current == head) //node belongs at haed of list
            {
                nln.setNext(head);
                head = nln;
            }
            else
            {
                if(current == null) //node belongs at rear of list
                {
                    tail.setNext(nln);
                    tail = nln;
                }
                else //node belongs in interior of list
                {
                    previous.setNext(nln);
                    nln.setNext(current);
                }
            }
        }
        count++;
           
   }
 }