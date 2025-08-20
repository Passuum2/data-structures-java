/* LinkedList.java - Poorly Implemented Linked List Class
 * Everyone
 * 31-Oct-23
 *  What each method does:
 * LinkedList(): Constructor
 * size(): Return Number of Elements
 * getFirst(): Returns the first element in the Linked List
 * removeFirst: Return the Remove First Elt
 * addFirst(): Adds an Elt to the front of the linked list
 * listIterator(): Returns Iterator
 * LinkedListIterator(): Constructor 
 * next(): Move Iterator Past Next Elt and Return its Data
 * hasNext(): Return true if there is an Elt after position
 * add(): Adds Elt before Position, Move Iterator Past Inserted Elt
 * remove(): Removes last tranversed Elt
 * set(): Set Data for last-Traversed Elt
 * main(): Tester for LinkedList Class
 */
import java.util.NoSuchElementException; //NoSuchElementException

public class LinkedList2 {
   //LinkedList - Poorly Implemented Linked List Class
   private Node llnFirst;
   private int currentSize;

   public LinkedList2() {
      //LinkedList(): Constructor
      //Implementation: Assignments to Instance Variables
      //System.out.println("LinkedList(): Enter");
      llnFirst = null;
      currentSize = 0;
      //System.out.println("LinkedList(): Return");
   }
   public int size(){
      //size(): Return Number of Elements
      //Implementation: Return Instance Varaible
      return currentSize;
   }

   public Object getFirst(){
      //getFirst(): Returns the first element in the Linked List
      //IMplementation: Returns llnFirst.data
      if (llnFirst == null){
         throw new NoSuchElementException();
      }
      return llnFirst.data;
   }

   public Object removeFirst() {
      //removeFirst: Return the Remove First Elt
      //Implementation: Assignment to Return value and Instance Variable, Decrement currentSize
      if (llnFirst == null){
         throw new NoSuchElementException();
      }
      Object oElt = llnFirst.data;
      llnFirst = llnFirst.next;
      currentSize-=1;
      return oElt;
   }

   public void addFirst(Object oElt) {
      //addFirst(): Adds an Elt to the front of the linked list
      //Implementation: Assigns new node to Instance Vaiable, Increment currentSize
      //System.out.printf("addFirst(): llnFirst(%s): Enter\n", oElt);
      Node newNode = new Node();
      newNode.data = oElt;
      newNode.next = llnFirst;
      llnFirst = newNode;
      currentSize+=1;
      //System.out.printf("addFirst(): llnFirst(%s): Return\n", llnFirst.data);
   }
   public LinkedListIterator listIterator(){
      //listIterator(): Returns Iterator
      //Implementation: new
      //System.out.println("ListIterator()");
      return new LinkedListIterator();
   }
   
   private class Node {
      //Node: Linked List Node
      //NOTE: Keeping Traditions 
      public Object data;
      public Node next;
   }
   public class LinkedListIterator {
      //LinkedListIterator: Class for Navigating Linked Lists    
      private Node position;
      private Node previous;

      public LinkedListIterator() {
         //LinkedListIterator(): Constructor 
         //Implementation: Assignment to Instance Variables
         //System.out.println("LinkedListIterator(): Enter");
         position = null;
         previous = null;
         //System.out.println("LinkedListIterator(): Return");
      }
      
      public Object next() {
         //next(): Move Iterator Past Next Elt and Return its Data
         //Implementation: Conditional Assignment to Instance Variable (Position)
         //System.out.printf("next():Enter);
         if (!hasNext()){
            throw new NoSuchElementException();
         }

         //if(position != null){System.out.printf("next(): Position(%s)\n", position.data);}
         
         previous = position; //Code is used for remove()
         if (position == null){
            position = llnFirst;
         } else {
            position = position.next;
         }
         //System.out.printf("next(): Return: Position(%s)\n", position.data);
         return position.data;
        }
      
      public boolean hasNext() {
         //hasNext(): Return true if there is an Elt after position
         //Implementation: Test position null
         if (position == null)
            return llnFirst != null;
         else
            return position.next != null;
      }
      public void add(Object oElt) {
         //add(): Adds Elt before Position, Move Iterator Past Inserted Elt
         //Implementation: Assignment on Position, Previous, and New Node, Increment currentSize
         if (position == null) {
            addFirst(oElt);
            position = llnFirst;
         } else {
            Node newNode = new Node();
            newNode.data = oElt;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
         currentSize+=1;
      }
      
      public void remove() {
         //remove(): Removes last tranversed Elt
         //Implementation: Assignments, Decrement currentSize
         if (previous == position){
            throw new IllegalStateException();
         }

         if (position == llnFirst) {
            removeFirst();
         } else  {
            previous.next = position.next;
         }
         position = previous;
         currentSize-=1;
      }

      public void set(Object element) {
         //set(): Set Data for last-Traversed Elt
         //Implementation: Assignment
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }
   } 
   public static void main(String[] args) {
      //main(): Tester for LinkedList Class
      //Implementation:  Calls to Methods
      //System.out.println("main(): Enter");
      System.out.println("TESTING LINKED_LIST CLASS");
      LinkedList2 llStates = new LinkedList2();
      llStates.addFirst("TN"); //List: TN
      System.out.printf("addFirst(%s)\n", "TN");
      llStates.addFirst("AL"); //List: AL, TN
      System.out.printf("addFirst(%s)\n", "AL");
      llStates.addFirst("AZ"); //List: AZ, AL, TN
      System.out.printf("addFirst(%s)\n", "AZ");
      llStates.addFirst("NY"); //List: NY, AZ, AL, TN
      System.out.printf("addFirst(%s)\n", "NY");
      System.out.println("removeFirst(): "+ llStates.removeFirst()); //List: AZ, AL, TN
      System.out.println("Expected: NY");
      System.out.println("getFirst(): "+ llStates.getFirst());
      System.out.println("Expected: AZ");
      System.out.println("size(): "+ llStates.size());
      System.out.println("Expected: 3\n");
      System.out.println("TESTING LINKED_LIST_ITERATOR CLASS");
      LinkedList2.LinkedListIterator oIterator = llStates.listIterator();
      System.out.println("next(): " + oIterator.next()); //it: Point: AL
      System.out.println("Expected: AZ");
      System.out.println("next(): " + oIterator.next()); //it: Point: TN
      System.out.println("Expected: AL");
      System.out.println("size(): " + llStates.size());
      oIterator.remove(); //List: AZ, TN
      System.out.println("remove() ");
      System.out.println("size(): " + llStates.size());
      System.out.println("Expected: 2");
      System.out.println("hasNext(): " + oIterator.hasNext());
      System.out.println("Expected: true");
      oIterator.add("TX"); //List: Az, TX, TN
      System.out.printf("add(%s)\n", "TX");
      System.out.println("size(): " + llStates.size());
      System.out.println("Expected: 3");
      oIterator.set("KY"); //List: AZ, KY, TN
      System.out.printf("set(%s)\n", "KY");
      //System.out.println("main(): Return");
   }
}