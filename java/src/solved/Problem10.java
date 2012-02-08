package solved;

import java.math.BigDecimal;

import util.Primes;

public class Problem10 {
	public static void main(String[] args) {
		System.out.println(sumPrimes(100000));
	}

	public static BigDecimal sumPrimes(long until) {
		//long[] primes = Primes.genPrimes(until);
		//long[] primes = Primes.genPrimesArray(until);
		long[] primes = Primes.genPrimesArrayList(until);
		BigDecimal sum = new BigDecimal(0);

		for (int i = 0; i < primes.length; ++i) {
			sum = sum.add(new BigDecimal(primes[i]));
		}

		return sum;
	}
}
