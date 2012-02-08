package util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrimesTest {
	@Test
	public void testIsPrime() {
		assertFalse(Primes.isPrime(1));
		assertTrue(Primes.isPrime(3));
		assertTrue(Primes.isPrime(7));
		assertTrue(Primes.isPrime(23));
		assertTrue(Primes.isPrime(59));
		assertTrue(Primes.isPrime(7919));
		assertFalse(Primes.isPrime(153));
		assertFalse(Primes.isPrime(128));
		assertFalse(Primes.isPrime(7909));
	}
	
	@Test
	public void testGenPrimesArray() {
		long[] primesExpect = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		long[] primesActual = Primes.genPrimesArray(100);
		 
		assertSame(primesExpect, primesActual);
	}
}
