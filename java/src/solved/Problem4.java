package solved;

public class Problem4 {
	public static void main(String[] args) {
		nDigitsMax(3);
	}
	
	static void nDigitsMax(int n) {
		int i;
		int j;
		long max=0;
		int start = (int) Math.pow(10, n-1);
		int end = (int) Math.pow(10, n);
		for (i=start; i<end; ++i) {
			for (j=start; j<end; ++j) {
				long p = i*j;
				
				if (isPalindrome(p)) {
					System.out.println(i + " * " + j + " = " + p);
					
					if (p > max)
						max = p;
				}
			}
		}
		
		System.out.println("Max: " + max);
	}
	
	static void testPalindrome() {
		System.out.println("88 " + isPalindrome(88));
		System.out.println("888 " + isPalindrome(888));
		System.out.println("71 " + isPalindrome(71));
		System.out.println("717 " + isPalindrome(717));
		System.out.println("813 " + isPalindrome(813));
		System.out.println("89698 " + isPalindrome(89698));
		System.out.println("896698 " + isPalindrome(896698));
	}
	
	static boolean isPalindrome(long n) {
		String s = new Long(n).toString();
		
		int mid = s.length()/2;
		int j;
		for (int i=0; i < mid; ++i) {
			j = s.length()-1 - i;
			
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		
		return true;
	}
}
