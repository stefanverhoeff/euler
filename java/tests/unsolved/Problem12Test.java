package unsolved;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Problem12Test {
	Problem12 problem12;
	
	@Before
	public void setUp() {
		problem12 = new Problem12();
	}
	
	//@Test
	public void solve() {
		problem12.solve();
	}
	
	@Test
	public void numDivs() {
		assertEquals(6, problem12.numberOfDivisors(28));
		assertEquals(4, problem12.numberOfDivisors(21));
		assertEquals(4, problem12.numberOfDivisors(6));
	}
	
	@Test
	public void nthTriangle() {
		assertEquals(1, problem12.nthTriangle(1));
		assertEquals(3, problem12.nthTriangle(2));
		assertEquals(15, problem12.nthTriangle(5));
		assertEquals(28, problem12.nthTriangle(7));
	}
}
