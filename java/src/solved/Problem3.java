package solved;

public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testFactor();

	}

	static void testFactor() {
		final long n = 600851475143l;
		
		for (long i=2; i < n; ++i) {
			if (n%i == 0 && isPrime(i)) {
				System.out.println("prime factor = " + i);
			}
		}
		
		System.out.println("done");
	}
	
	static boolean isPrime(long n) {
		for (long i=2; i <= n/2; ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
