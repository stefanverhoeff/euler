package solved;

public class Problem5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( evenlyDivided(20) );
	}
	
	static long evenlyDivided(int num) {
		long i=1;
		long j;
		
		while (true) {
			for (j=num; j > 0; --j) {
				if (i%j > 0)
					break;
			}
			
			if (j == 0)
				return i;
			
			i++;
		}
	}

}
