package th.ac.utcc.cpe.data_structures;

public class LinkedList {
	private Link first;
	private int count;
	
	public LinkedList() {
		first = null;
		count = 0;
	}
	
	public void insertFirst(Link newLink) {
		newLink.next = first;
		first = newLink;
		count++;
	}
	
	public Link search(int key) {
		Link current = first;
		while(current.getiData() != key) {
			if(current.next == null) 
				return null; 
			else
				current = current.next;
		}
		
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while(current.getiData() != key) {
			if(current.next == null) 
				return null; 
			else {
				previous = current;
				current = current.next;
			}
		}
		
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		
		count--;
		
		return current;
	}
	
	public int length() {
		return count;
	}
	
	public String toString() {
		String str = "";
		Link current = first;
		while(current != null) {
			str += current + "\n";
			current = current.next;
		}
		
		return str;
	}
}
