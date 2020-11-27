package th.ac.utcc;

public class BubbleSortArray {
	private int []element;
	private int eSize;
	
	public BubbleSortArray(int size) {
		if(size > 0)
			this.element = new int[size];
		else
			this.element = new int[10];
		eSize = 0;
		
	}
	public void insert(int e) {
		this.element[eSize] = e;
		eSize++;
		
	}
	public void show() {
		for (int i = 0; i < eSize; i++) {
			System.out.print(this.element[i]+ " ");
		}
		System.out.print(" ");
	}
	public void bubbleSort() {
		int out , in;
		
		for(out = eSize - 1; out> 0; out--) {
			for(in = 0; in < out; in++) {
				if(this.element[in] < this.element[in +1]) {
					this.swap(in, in+1);
				}
		}
	}

	}
	private void swap(int left, int right) {
		int temp = this.element[left];
		this.element[left] = this.element[right];
		this.element[right]= temp;
		
	}
	public static void main(String[] arga) {
		int max = 20;
		BubbleSortArray bubble = new BubbleSortArray(max);
		
		
		bubble.insert(87);
		bubble.insert(43);
		bubble.insert(95);
		bubble.insert(32);
		bubble.insert(91);
		bubble.insert(78);
		bubble.insert(26);
		bubble.insert(12);
		
		System.out.print("Original Order: ");
		bubble.show();
		
		bubble.bubbleSort();
		System.out.print(" Sorted Order: ");
		bubble.show();
		
	}
	}