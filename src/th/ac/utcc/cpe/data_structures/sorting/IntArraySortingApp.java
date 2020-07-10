package th.ac.utcc.cpe.data_structures.sorting;


public class IntArraySortingApp {

	public static void main(String[] args) {
		int maxCount = 20;
		long avg = 0;
		
		for(int count=0; count < maxCount; count++) {
			int size = 3000;
			IntArrayBubbleSort bubbleSort = new IntArrayBubbleSort(size);

			for (int i = 0; i < size; i++) {
				bubbleSort.insert((int) (size * Math.random()));
			}

			long start = System.nanoTime();
			bubbleSort.sort();
			long end = System.nanoTime();
			long elapse = end - start;
			
			avg += elapse;

			System.out.println("Elapse Time(" + count + "): " + elapse + " ns");
		}
		
		System.out.println("Average Elapse Time:" + (avg/maxCount) + " ns" );
	}

}
