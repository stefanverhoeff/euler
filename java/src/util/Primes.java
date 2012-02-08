package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Primes {
	public static boolean isPrime(long n) {
		// Quickies:
		if (n % 2 == 0 && n != 2)
			return false;
		if (n % 3 == 0 && n != 3)
			return false;
		if (n % 5 == 0 && n != 5)
			return false;

		for (long i = 7; i <= n / 2; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		if (n == 1)
			return false;

		return true;
	}

	public static long[] genPrimes(long until) {
		Set<Long> primesSet = new TreeSet<Long>();
		primesSet.add(2L);

		long start = System.currentTimeMillis();
		long lapStart = start;
		long elapsed;
		float pecentageDone;
		for (long i = 3, j = 1; i < until; i += 2, ++j) {
			if (isPrimeInSet(i, primesSet)) {
				primesSet.add(i);
			}
			if (j % 1500000 == 0) {
				elapsed = System.currentTimeMillis() - lapStart;
				pecentageDone = (100.0f / until) * i;
				System.out.printf("%d @ %dms %.2f%% done %d primes\n", i, elapsed, pecentageDone, primesSet.size());
				lapStart = System.currentTimeMillis();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

		// Convert to primitive array for speed
		long primesArray[] = new long[primesSet.size()];
		int c = 0;
		for (Long lo : primesSet) {
			primesArray[c++] = lo;
		}

		return primesArray;
	}
	
	public static long[] genPrimesArray(long until) {
		long primesArray[] = new long[(int) (until / 10)];
		primesArray[0] = 2;
		
		long start = System.currentTimeMillis();
		long lapStart = start;
		long elapsed;
		float pecentageDone;
		int primes = 1;
		for (long i = 3, j = 1; i < until; i += 2, ++j) {
			if (isPrimeInArray(i, primesArray)) {
				primesArray[primes++] = i;
			}
			if (j % 1500000 == 0) {
				elapsed = System.currentTimeMillis() - lapStart;
				pecentageDone = (100.0f / until) * i;
				System.out.printf("%d @ %dms %.2f%% done %d primes\n", i, elapsed, pecentageDone, primesArray.length);
				lapStart = System.currentTimeMillis();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		return primesArray;
	}
	
	public static long[] genPrimesArrayList(long until) {
		List<Long> primesArray = new ArrayList<Long>((int) (until / 10));
		primesArray.add(2l);
		
		long start = System.currentTimeMillis();
		long lapStart = start;
		long elapsed;
		float pecentageDone;
		int primes = 1;
		for (long i = 3, j = 1; i < until; i += 2, ++j) {
			if (isPrimeInArrayList(i, primesArray)) {
				primesArray.add(i);
			}
			if (j % 1500000 == 0) {
				elapsed = System.currentTimeMillis() - lapStart;
				pecentageDone = (100.0f / until) * i;
				System.out.printf("%d @ %dms %.2f%% done %d primes\n", i, elapsed, pecentageDone, primesArray.size());
				lapStart = System.currentTimeMillis();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

		long[] longArray = new long[primesArray.size()];
		for (int i=0; i < primesArray.size(); ++i) {
			longArray[i] = primesArray.get(i);
		}
		
		return longArray;
	}

	public static boolean isPrimeInSet(long n, Set<Long> primes) {
		long breakpoint = (long) Math.sqrt(n); //n / 2 + 1;
		for (long i : primes) {
			if (n % i == 0) {
				return false;
			}
			if (i > breakpoint)
				break;
		}
		
		return true;
	}
	
	public static boolean isPrimeInArray(long n, long[] primes) {
		long breakpoint = (long) Math.sqrt(n);
		for (long i : primes) {
			if (n % i == 0)
				return false;
			if (i > breakpoint)
				break;
		}
		
		return true;
	}
	
	public static boolean isPrimeInArrayList(long n, List<Long> primes) {
		long breakpoint = (long) Math.sqrt(n);
		for (long i : primes) {
			if (n % i == 0)
				return false;
			if (i > breakpoint)
				break;
		}
		
		return true;
	}
}
