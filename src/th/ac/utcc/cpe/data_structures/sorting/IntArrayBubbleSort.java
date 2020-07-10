package th.ac.utcc.cpe.data_structures.sorting;

public class IntArrayBubbleSort extends IntArraySorting {

	public IntArrayBubbleSort(int size) {
		super(size);
	}

	@Override
	public void sort() {
		for(int out = eSize - 1; out > 0; out--) {
			for(int in = 0; in < out; in++) {
				if(elements[in] > elements[in+1]) {
					int temp = elements[in];
					elements[in] = elements[in+1];
					elements[in+1] = temp;
				}
			}
		}
		
	}

}
