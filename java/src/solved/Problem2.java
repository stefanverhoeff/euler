package solved;
import java.util.ArrayList;
import java.util.List;


public class Problem2 {
	public static void main(String[] args) {
		List<Integer> nums = fib(1, 2);
		long sum = 0;
		for (Integer i : nums) {
			if (i % 2 == 0)
				sum += i;
		}
		
		System.out.println(sum);
	}
	
	static List<Integer> fib(int one, int two) {
		if (two > 4000000)
			return new ArrayList<Integer>();
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(two);
		l.addAll(fib(two, one+two));
		return l;
	}
}
