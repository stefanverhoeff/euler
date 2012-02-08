package solved;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import solved.Problem187;

public class Problem187Test {
	@Test
	public void testIsPrime() {
		assertFalse(Problem187.isPrime(1));
		assertTrue(Problem187.isPrime(3));
		assertTrue(Problem187.isPrime(7));
		assertTrue(Problem187.isPrime(23));
		assertTrue(Problem187.isPrime(59));
		assertTrue(Problem187.isPrime(7919));
		assertFalse(Problem187.isPrime(153));
		assertFalse(Problem187.isPrime(128));
		assertFalse(Problem187.isPrime(7909));
	}
	
	@Test
	public void testIsComposit2() {
		long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
		
		assertFalse(Problem187.isComposit2(2, primes));
		assertFalse(Problem187.isComposit2(23, primes));
		assertFalse(Problem187.isComposit2(436, primes));
		assertTrue(Problem187.isComposit2(4, primes));
		assertTrue(Problem187.isComposit2(6, primes));
		assertTrue(Problem187.isComposit2(9, primes));
		assertTrue(Problem187.isComposit2(10, primes));
		assertTrue(Problem187.isComposit2(14, primes));
		assertTrue(Problem187.isComposit2(15, primes));
		assertTrue(Problem187.isComposit2(21, primes));
		assertTrue(Problem187.isComposit2(22, primes));
		assertTrue(Problem187.isComposit2(25, primes));
		assertTrue(Problem187.isComposit2(26, primes));
		assertTrue(Problem187.isComposit2(437, primes));
	}
	
	@Test
	public void testGenComposites3() {
		Set<Long> until10 = Problem187.genComposites3(10);
		assertEquals(3, until10.size());
		
		Set<Long> until30 = Problem187.genComposites3(30);
		assertEquals(10, until30.size());
	}
	
	@Test
	public void large100000() {
		Set<Long> solved = Problem187.genComposites3(100000);
		System.out.println(solved.size());
	}
	
	@Test
	public void large1000000() {
		Set<Long> solved = Problem187.genComposites3(1000000);
		System.out.println(solved.size());
	}
	
	@Test
	public void solve() {
		Set<Long> solved = Problem187.genComposites3(100000000);
		System.out.println(solved.size());
	}
}
