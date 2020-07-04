package th.ac.utcc.cpe.data_structures;

public class LinkedListApp {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		
		myList.insertFirst(new Link(22, 2.99));
		myList.insertFirst(new Link(44, 4.99));
		myList.insertFirst(new Link(66, 6.99));
		myList.insertFirst(new Link(88, 8.99));
		
		System.out.println(myList);
		
		Link result = myList.search(44);
		if(result != null) {
			System.out.println("Search result: " + result);
		} else {
			System.out.println("Cannot find a result.");
		}
		
		result = myList.delete(66);
		if(result != null) {
			System.out.println("Deleted: " + result);
		} else {
			System.out.println("Cannot delete.");
		}
		
		System.out.println(myList);
	}

}
