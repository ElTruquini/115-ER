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

	public Heap() {
		heapArray = new Comparable[MAX];// REVISIT SIZE THAT I WANT TO USE**********************
		size = 0;
	}

	public boolean isEmpty (){
		return size==0; //heapArray.size() == 0;
	}

	public int size(){
		return size;
	}

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

	public java.lang.Comparable removeRootItem(){
		if (heapArray[0] ==null){
			throw new RuntimeException("Heap is empty.");
		}
		//copy the item from the last node into the root
		heapArray[0]=heapArray[size-1];
		size --;
		heapRebuild(0, size);
		return heapArray[0]; // NEED TO CHANGE THIS ***************
	}

	public void heapRebuild (int root, int size){
		System.out.println("\nHEAP REBUILD");
		int child, rightChild; 
		if (root+1 <= size ){ //if root is not leaf
			child = 2 * root +1;
			if (root + 2 <= size ){ //root has right child
				rightChild = child +1;
				//System.out.println("Child: " + heapArray[child]);
				//System.out.println("Rightchild " + heapArray[rightChild]);
				if (heapArray[rightChild].compareTo(heapArray[child]) < 0){
					child = rightChild;
					//System.out.println("I made it in the IF");
				}
			}
			//root is smaller than child
			System.out.println("Root " + heapArray[root]);
			System.out.println("Child " + heapArray[child]);
			if (heapArray[root].compareTo(heapArray[child]) > 0) {
				System.out.println("Root is smaller than child");


				//AQUI ME QUEDE, PAGINA 671 DEL LIBRO. TENGO QUE TERMINAR
				//SWAP ITEMS RECURSIVE.
				//FUNCIONO HASTA LINEA 84
			}
		}	
	}


	public void print (){
		System.out.println("\n PRINTING");
		for (int i = 0; i < size ; i++ ){
			System.out.println(heapArray[i]);
		}
	}

	public static void main(String[] args) {
		Heap test = new Heap ();
		ER_Patient p1 = new ER_Patient("Walk-in"); //4
		ER_Patient p2 = new ER_Patient("Life-threatening"); //1
		ER_Patient p3 = new ER_Patient("Chronic"); //2
		ER_Patient p4 = new ER_Patient("Major fracture"); //3
		ER_Patient p5 = new ER_Patient("Chronic"); //2

		//System.out.println(p1);
		//System.out.println(p5);

		test.insert(p1);
		test.insert(p2);
		test.insert(p3);
		test.insert(p4);
		

		test.print();
		
		test.removeRootItem();
		test.print();
		//System.out.println("Compare:");
		//System.out.println(p1.compareTo(p2));
		//test.heapRebuild(0, test.size());
	}

}