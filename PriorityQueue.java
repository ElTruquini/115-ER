/**
 * CSC115 Assignment 5 : ER
 * PriorityQueue.java
 * Created for use by CSC115 Spring2016 
 * Name: Daniel Olaya Moran
 * ID: V00855054
 * Date: March 17, 2016 
*/

import java.util.NoSuchElementException;

public class PriorityQueue {
	
	private Heap heap;
	
	//Creates an empty priority queue.
	public PriorityQueue() {
 		heap = new Heap ();
	}

	/**
	 * Inserts an item into the queue.
	 * @param item - The item to insert.
	 */
 	public void enqueue(java.lang.Comparable item){
 		heap.insert(item);
 	}

	/**
	* Removes the highest priority item from the queue.
	* @return The item.
	* @throws java.util.NoSuchElementException - if the queue is empty.
	*/
 	public java.lang.Comparable dequeue(){
 		if (heap.isEmpty() == true){
 			throw new NoSuchElementException ("The queue is empty");
 		}
 		return heap.removeRootItem();
 	}

 	// Internal helper method
 	public void print (){
 		heap.print();
 	}

	/**
	* Retrieves, but does not remove the next item out of the queue.
	* @return The item with the highest priority in the queue.
	* @throws java.util.NoSuchElementException - if the queue is empty.
	*/
 	public java.lang.Comparable peek(){
 		 if (heap.isEmpty() == true){
 			throw new NoSuchElementException ("The queue is empty");
 		}
		return heap.getRootItem();
 	}
 	
 	/**
	* @return True if the queue is empty, false if it is not.
	*/
 	public boolean isEmpty(){
 		return heap.isEmpty();
 	}
 	
 	//Testing method
 	public static void main(String[] args) {
 	/*	
 		PriorityQueue hippie = new PriorityQueue();

 		ER_Patient p1 = new ER_Patient("Walk-in"); //4
		ER_Patient p2 = new ER_Patient("Life-threatening"); //1
		ER_Patient p3 = new ER_Patient("Chronic"); //2
		ER_Patient p4 = new ER_Patient("Life-threatening"); //1
		ER_Patient p5 = new ER_Patient("Chronic"); //2
		ER_Patient p6 = new ER_Patient("Walk-in"); //4

		System.out.println("IS EMPTY (true): " + hippie.isEmpty());
		//System.out.println("PEEKING: " + hippie.peek() );

		hippie.enqueue(p1);
		hippie.enqueue(p2);
		hippie.enqueue(p3);
		hippie.print();
		System.out.println();
		hippie.dequeue();
		System.out.println("PEEKING: " + hippie.peek() );
		hippie.enqueue(p4);

		hippie.print();
		System.out.println("IS EMPTY (false): " + hippie.isEmpty());
	*/
 	}
}
	
