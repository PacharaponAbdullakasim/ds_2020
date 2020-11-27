package th.ac.utcc;

import th.ac.utcc.BubbleSortGeneric;

public class BubbleSortGeneric {
	private double[] element;
	private double eSize;
	
	public BubbleSortGeneric(long size) {
		if(size > 0)
			this.element = new double[(int) size];
		else
			this.element = new double[10];
		eSize = 0;
		
	}
	public void insert(long e) {
		this.element[(int) eSize] = (int) e;
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
		
		for(out = (int) (eSize - 1); out> 0; out--) {
			for(in = 0; in < out; in++) {
				if(this.element[in] > this.element[in +1]) {
					this.swap(in, in+1);
				}
		}
	}

	}
	private void swap(int left, int right) {
		int temp = (int) this.element[left];
		this.element[left] = this.element[right];
		this.element[right]= temp;
		
	}
	public static void main(String[] arga) {
		int max = 20;
		BubbleSortGeneric bubble = new BubbleSortGeneric(max);
		
		
		bubble.insert(223);
		bubble.insert(211);
		bubble.insert(202);
		bubble.insert(004);
		bubble.insert(241);
		bubble.insert(242);
		bubble.insert(231);
		
		System.out.print("Original Order: ");
		bubble.show();
		
		bubble.bubbleSort();
		System.out.print(" Sorted Order: ");
		bubble.show();
		
	}
	}