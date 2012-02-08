package solved;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import solved.Problem10;

public class Problem10Test {
	@Test
	public void below10() {
		assertEquals(17, Problem10.sumPrimes(10));
	}

	@Test
	public void below50() {
		assertEquals(2 + 3 + 5 + 7 + 11 + 13 + 17 + 19 + 23 + 29 + 31 + 37 + 41
				+ 43 + 47, Problem10.sumPrimes(50));
	}

	@Test
	public void takeAWhile() {
		BigDecimal sum = Problem10.sumPrimes(100000);
		System.out.println(sum);
	}

	@Test
	public void solve() {
		BigDecimal sum = Problem10.sumPrimes(2000000);
		System.out.println(sum);
	}
}
