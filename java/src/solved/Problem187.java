package solved;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import util.Primes;

public class Problem187 {
	public static void main(String[] args) {
		//System.out.println("primes2 < n^8 " + genPrimesZeef(100000000).length);
		
		//System.out.println("composits < 30 " + genComposites3(30));

		long start;
		for (int i=1000; ; i*=10) {
			//System.out.println("composits < " + i + " " + genComposites3(i).size());
			
			start = System.currentTimeMillis();
			System.out.println("primes1 < " + i + " " + genPrimes(i).length + " in " + (System.currentTimeMillis()-start) + "ms");
			start = System.currentTimeMillis();
			System.out.println("primes2 < " + i + " " + genPrimesZeef(i).length + " in " + (System.currentTimeMillis()-start) + "ms");
			
			//break;
		}
		
		
		
		//Set<Long> composites = genComposits2(100000);
		//System.out.println("composits < 10^5 " + composits.size());
		
		//Set<Long> composites2 = new TreeSet<Long>(genComposites2(100000000));
		//System.out.println("composits < 10^8 " + composites2 + " size " + composites2.size());
	}
	
	static Set<Long> genComposites2(long until) {
		Set<Long> composits = new TreeSet<Long>();
		
		long[] primes = genPrimes(until/2 + 1);
		Arrays.sort(primes);
		
		System.out.println("Got primes: " + primes.length);
		
		long timeStart = System.currentTimeMillis();
		for (long i=2; i < until; ++i) {
			if (i%1000 == 0) {
				double progress = i/(until/100.0);
				double elapsed = System.currentTimeMillis() - timeStart;
				double remaining = (elapsed/progress) * (100 - progress) / 1000.0;
				System.out.printf("n = %d %.4f%% done %.2fs %.2fm %.2fh left\n", i, progress, remaining, remaining/60, remaining/3600);
			}
			
			if (isComposit2(i, primes))
				composits.add(i);
		}
		
		return composits;
	}
	
	static Set<Long> genComposites3(long until) {
		Set<Long> composits = new TreeSet<Long>();
		
		long[] primes = Primes.genPrimesArrayList(until/2 + 1);
		Arrays.sort(primes);
		
		//System.out.println("Got primes: " + primes.length);
		
		int i;
		int j;
		for (i=0; i < primes.length; ++i) {
			for (j=0; j < primes.length; ++j) {
				if (primes[i]*primes[j] >= until)
					break;
				composits.add(primes[i]*primes[j]);
			}
		}
		
		return composits;
	}
	
	static boolean isComposit2(long n, final long[] primes) {
		for (long i : primes) {
			if (i*2 > n)
				break;
			
			for (long j : primes) {
				if (i*j > n)
					break;
				
				if (i*j == n)
					return true;
			}
		}
		
		return false;
	}
	
	static long[] genPrimesZeef(final int until) {
		List<Integer> allNumbers = new ArrayList<Integer>(until);
		
		// Fill with all numbers
		//allNumbers.add(2);
		for (int i=2; i < until/2+1; ++i) {
			allNumbers.add(i);
		}

		int n, j;
		// Do the zeef
		for (int i=0; i < allNumbers.size(); ++i) {
			// Mark all multiples of as non-prime
			if (allNumbers.get(i) == null)
				continue;
			
//			for (n = i+i; n < until; n=n+j) {
//				allNumbers.remove();
//			}
		}

		// Count number of primes
		int numPrimes=0;
		for (int i=0; i < allNumbers.size(); ++i) {
			if (allNumbers.get(i) != null) {
				numPrimes++;
			}
		}
		
		// Leftovers are the primes!
		long[] primes = new long[numPrimes];
		for (int i=0; i < allNumbers.size(); ++i) {
			primes[i] = allNumbers.get(i);
		}
		
		return primes;
	}
	
	static long[] genPrimes(long until) {
		Set<Long> primesSet = new HashSet<Long>((int) until/10);
		primesSet.add(2l); // 2 as long
		
		//System.out.println("Seeking primes until " + until);
		for (long i=3; i < until; i+=2) {
			if (isPrime2(i, primesSet)) {
//				if (primesSet.size() % 1000 == 0) {
//					System.out.print('.');
//					System.out.println("Prime " + i);
//				}
				primesSet.add(i);
			}
		}
		
//		System.out.print('\n');
		
		// Convert to primitive array for speed
		long primesArray[] = new long[primesSet.size()];
		int c=0;
		for (Long lo : primesSet) {
			primesArray[c++] = lo;
		}
		
		return primesArray;
	}
	
	static boolean isPrime(long n) {
		// Quickies:
		if (n%2==0 && n!= 2)
			return false;
		if (n%3==0 && n != 3)
			return false;
		if (n%5==0 && n != 5)
			return false;
		
		for (long i=7; i <= n/2; i+=2) {
			if (n % i == 0) {
				return false;
			}
		}

		if (n==1)
			return false;
		
		return true;
	}
	
	static boolean isPrime2(long n, Set<Long> primes) {
		for (long i : primes) {
			if (n % i == 0) { // || i > n/2+1) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean isPrime2(int n, Set<Integer> primes) {
		for (int i : primes) {
			if (n % i == 0) { // || i > n/2+1) {
				return false;
			}
		}
		
		return true;
	}
}

