package th.ac.utcc.cpe.data_structures;

public class Reviews {

	public int add(int x, int y) {
		int z = x + y;
		return z;
	}
	
	public double divide(int x, int y) {
		double z = (double)x / y;
		return z;
	}
	
	public static void main(String[] args) {
		Reviews r = new Reviews();
		int myadd = r.add(1, 2);
		System.out.println("1 + 2 = " + myadd);

		double mydivide = r.divide(1, 2);
		System.out.println("1 / 2 = " + mydivide);
	}

}
