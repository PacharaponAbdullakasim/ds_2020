package th.ac.utcc.cpe.data_structures.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import th.ac.utcc.cpe.data_structures.Link;
import th.ac.utcc.cpe.data_structures.LinkedList;

class LinkedListTest {

	LinkedList myList;
	
	@BeforeEach
	void setUp() throws Exception {
		myList = new LinkedList();	
		myList.insertFirst(new Link(22, 2.99));
		myList.insertFirst(new Link(44, 4.99));
		myList.insertFirst(new Link(66, 6.99));
		myList.insertFirst(new Link(88, 8.99));
	}

	@Test
	void testSearch() {
		Link result = myList.search(66);
		int iData = 66;
		double dData = 6.99;
		
		assertEquals(iData, result.getiData());
		assertEquals(dData, result.getdData());
	}
	
	@Test
	void testDelete() {
		Link result = myList.delete(22);
		int iData = 22;
		double dData = 2.99;
		
		assertEquals(iData, result.getiData());
		assertEquals(dData, result.getdData());
		
		int count = 3;
		assertEquals(count, myList.length());
	}

}
