package th.ac.utcc.cpe.data_structures.sorting;

public class IntArraySelectionSort extends IntArraySorting {

	public IntArraySelectionSort(int size) {
		super(size);
	}

	@Override
	public void sort() {
		int min;
		for(int out = 0; out < eSize - 1; out++) {
			min = out;
			for(int in = out+1; in < eSize; in++) {
				if(elements[in] < elements[min]) {
					min = in;
				}
			}
			
			// swap
			int temp = elements[out];
			elements[out] = elements[min];
			elements[min] = temp;
		}
	}

}
