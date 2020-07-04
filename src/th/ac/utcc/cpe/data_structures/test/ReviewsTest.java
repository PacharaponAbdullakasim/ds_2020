package th.ac.utcc.cpe.data_structures.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import th.ac.utcc.cpe.data_structures.Reviews;

class ReviewsTest {
	Reviews r;
	
	@BeforeEach
	void setUp() throws Exception {
		r = new Reviews();
	}

	@Test
	void testAdd() {
		int x = 1;
		int y = 2;
		int z = r.add(x, y);
		assertEquals(x+y, z);
	}

	@Test
	void testDivide() {
		int x = 1;
		int y = 2;
		double z = r.divide(x, y);
		assertEquals(0.5, z);
	}
}
