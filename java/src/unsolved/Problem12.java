package unsolved;

import java.util.HashMap;
import java.util.Map;

import util.Primes;

public class Problem12 {
	//static long[] primeDivisors = Primes.genPrimesArray(10000000);
	Map<Integer,Integer> lut = new HashMap<Integer,Integer>();
	
	void solve() {
		int largestDiv = 0;
		int numDivs;
		int num;
		
		for (int n=0; ; ++n) {
			// Generate n-th triangle number
			num = nthTriangle(n);
			
			// Record tracking
			numDivs = numberOfDivisors(num);
			if (numDivs > largestDiv) {
				largestDiv = numDivs;
				System.out.println("New record: " + largestDiv + " by " + num + " the " + n + "th triangle number");
			}
			
			// Check if they have over 500 divisors
			//if (numDivs > 500) {
			if (numDivs > 300) {
				System.out.println("Done!");
				break;
			}
		}
	}
	
	int nthTriangle(int n) {
		int num = 0;
		for (int i=0; i <= n; ++i) {
			num += i;
		}
		
		return num;
	}
	
	int numberOfDivisors(int num) {
		int numDivs = 1; // Start at 1 for self-counting
		int count = 3;
		int prevDiv = 0;
		int halfNum = num/2;
		
		all:
		for (int div = halfNum; div > 0; div = num/count) {
			// Shortcut for already calculated dividers
			if (num%div == 0 && div != prevDiv) {
				if (lut.containsKey(div)) {
					numDivs += lut.get(div);
					break;
				}
				numDivs++;
			}
			
			prevDiv = div;
			
			while (num%count != 0) {
				count++;
				
				if (count > halfNum)
					break all;
			}
		}
		
		lut.put(num, numDivs);
		
		return numDivs;
	}
}
