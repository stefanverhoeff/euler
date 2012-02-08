package solved;

import java.util.Arrays;

public class Problem9 {
	public static void main(String[] args) {
		int[] triplet = findTriplet();
		System.out.println(Arrays.toString(triplet));
		System.out.println(triplet[0]*triplet[1]*triplet[2]);
	}
	
	static int[] findTriplet() {
		int[] triplet = new int[3];
		
		all:
		for (int a=1; a < 1000; ++a) {
			for (int b=a; b < 1000; ++b) {
				for (int c=b; c < 1000; ++c) {
					if (a*a + b*b == c*c && a+b+c == 1000) {
						triplet[0] = a;
						triplet[1] = b;
						triplet[2] = c;
						break all;
					}
				}
			}
		}
		
		return triplet;
	}
}
