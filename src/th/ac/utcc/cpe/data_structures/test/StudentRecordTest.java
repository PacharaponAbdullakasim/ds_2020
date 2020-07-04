package th.ac.utcc.cpe.data_structures.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import th.ac.utcc.cpe.data_structures.StudentRecord;

class StudentRecordTest {

	StudentRecord r;
	
	@BeforeEach
	void setUp() throws Exception {
		r = new StudentRecord();
	}

	@Test
	void testId() {
		long x = 123;
		r.setId(x);
		assertEquals(x, r.getId());
	}
	
	@Test
	void testName() {
		String s = "UTCC";
		r.setName(s);
		assertEquals(s, r.getName());
	}

}
