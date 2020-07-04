package th.ac.utcc.cpe.data_structures;

public class Link {
	private int iData;
	private double dData;
	Link next;
	
	public Link(int iData, double dData) {
		this.iData = iData;
		this.dData = dData;
	}
	
	public int getiData() {
		return iData;
	}

	public void setiData(int iData) {
		this.iData = iData;
	}

	public double getdData() {
		return dData;
	}

	public void setdData(double dData) {
		this.dData = dData;
	}

	public String toString() {
		return "{" + this.iData + "," + this.dData + "}";
	}
}
