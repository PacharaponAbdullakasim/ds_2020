package th.ac.utcc.cpe.data_structures.sorting;

public abstract class IntArraySorting implements Sorting {
	protected int [] elements;
	protected int eSize;
	
	public IntArraySorting(int size) {
		if(size > 0) {
			elements = new int[size];
		} else {
			elements = new int[10];
		}
		
		eSize = 0;
	}
	
	public void insert(int e) {
		if(eSize < elements.length) {
			elements[eSize++] = e;
		}
	}
}
