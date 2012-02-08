package solved;

public class Problem7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findPrime(10001));
	}

	static long findPrime(int n) {
		int numPrimes = 0;
		int i;
		for (i=2; numPrimes < n; ++i) {
			if (isPrime(i))
				numPrimes++;
		}
		
		return i-1;
	}
	
	static boolean isPrime(int p) {
		for (int i=2; i < p/2+1; ++i) {
			if (p%i == 0)
				return false;
		}
		
		return true;
	}
}
