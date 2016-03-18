/**
 * CSC115 Assignment 5 : ER
 * Heap.java
 * Created for use by CSC115 Spring2016 
 * Name: Daniel Olaya Moran
 * ID: V00855054
 * Date: March 17, 2016 
*/

import java.util.NoSuchElementException;

@SuppressWarnings({"unchecked"})

public class Heap {

	static final int MAX = 100;
	int size;

	private Comparable[] heapArray;

	//Creates an empty heap
	public Heap() {
		heapArray = new Comparable[MAX];// REVISIT SIZE THAT I WANT TO USE**********************
		size = 0;
	}

	/**
	* @return True if the heap is empty, false if it is not.
	*/
	public boolean isEmpty (){
		return size==0; //heapArray.size() == 0;
	}

	/**
	* @return The number of items in the heap.
	*/
	public int size(){
		return size;
	}

	/**
	 * Inserts an item into the heap.
	 * @param item - The newly added item.
	 */
	public void insert (java.lang.Comparable item){
		heapArray[size]= item;

		//trickle new item up to appropriate spot in the tree
		int place = size;
		int parent = (place-1)/2;
		Comparable[] temp = new Comparable[1];
		System.out.println("INSERTING " + item);
		System.out.println("Place compare to Parent " + heapArray[place].compareTo(heapArray[parent]));
		
		while ( (parent >= 0) && (heapArray[place].compareTo(heapArray[parent]) < 0)){
			temp[0] = heapArray[place];
			heapArray[place] = heapArray[parent];
			heapArray[parent] = temp[0];
		}
		size ++;
	}

	/**
	* Removes the item at the root node of the heap.
	* @return The item at the root of the heap.
	* @throws java.util.NoSuchElementException - if the heap is empty.
	*/
	public java.lang.Comparable removeRootItem(){
		if (size == 0){
			throw new RuntimeException("Heap is empty.");
		}
		//copy the item from the last node into the root
		heapArray[0]=heapArray[size-1];
		size --;
		heapRebuild(0, size);
		return heapArray[0]; 
	}

	/**
	* Retrieves, without removing the item in the root.
	* @return The top item in the tree.
	* @throws java.lang.NullPointerException - if the heap is empty.
	*/
	public java.lang.Comparable getRootItem(){
		if (size == 0){
			throw new RuntimeException ("Heap is empty");
		}
		return heapArray[0];
	}

	//Internal helper method used to rebuild heap after deletion of root.
	public void heapRebuild (int root, int size){
		Comparable[] temp = new Comparable[1];
		System.out.println("\nHEAP REBUILD");
		int child, rightChild; 
		if (root+1 <= size ){ //if root is not leaf
			child = 2 * root +1;
			if (root + 2 <= size ){ //root has right child
				rightChild = child +1;
				//System.out.println("PRE-Child: " + heapArray[child]+ " root num " +root);
				//System.out.println("PRE-Rightchild " + heapArray[rightChild]+ " child num " + child);
				if (heapArray[rightChild].compareTo(heapArray[child]) < 0){
					child = rightChild;
				}
			}
			//root is smaller than child
			//System.out.println("Root " + heapArray[root] + " root num " +root);
			//System.out.println("Child " + heapArray[child] + " child num " + child);
			if ((heapArray[child] != null)&&(heapArray[root].compareTo(heapArray[child]) > 0)  ) {
				temp[0] = heapArray[root];
				heapArray[root] = heapArray[child];
				heapArray[child] = temp[0];

				print();
				heapRebuild(child, size);
			}
		}	
	}

	// Internal helper method, prints the heap array
	public void print (){
		//System.out.println("\n PRINTING");
		for (int i = 0; i < size ; i++ ){
			System.out.println(heapArray[i]);
		}
	}

	// Used for internal testing purposes
	public static void main(String[] args) {
		/*
		Heap test = new Heap ();
		ER_Patient p1 = new ER_Patient("Walk-in"); //4
		ER_Patient p2 = new ER_Patient("Life-threatening"); //1
		ER_Patient p3 = new ER_Patient("Chronic"); //2
		ER_Patient p4 = new ER_Patient("Major fracture"); //3
		ER_Patient p5 = new ER_Patient("Chronic"); //2
		ER_Patient p6 = new ER_Patient("Walk-in"); //4

		//System.out.println(p1);
		//System.out.println(p5);
		test.removeRootItem();
		test.getRootItem();
		
		test.insert(p1);
		test.insert(p2);
		test.insert(p3);
		test.insert(p4);
		test.insert(p5);
		test.insert(p6);

		test.print();
		
		test.removeRootItem();
		test.print();
		//System.out.println("Compare:");
		//System.out.println(p1.compareTo(p2));
		//test.heapRebuild(0, test.size());
		*/	

	}

}
