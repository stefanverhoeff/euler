package solved;

public class Problem6 {
	public static void main(String[] args) {
		long sum1 = sumOfSquares(100);
		long sum2 = squareOfSums(100);
		System.out.println(sum1 +  " - " + sum2 + " = " + (sum1-sum2));
	}
	
	static long sumOfSquares(int num) {
		long sum = 0;
		
		for (int i=1; i <= num; ++i) 
			sum += i*i;
		
		return sum;
	}
	
	static long squareOfSums(int num) {
		long sum = 0;
		
		for (int i=1; i <= num; ++i) 
			sum += i;
		
		return sum*sum;
	}
}
