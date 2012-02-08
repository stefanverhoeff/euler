package solved;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import solved.Problem11;

public class Problem11Test {
	static int[][] testMatrix1 = {	{1,1,1,1,1},
									{1,1,1,1,1},
									{1,1,1,1,1},
									{1,1,1,1,1},
									{1,1,1,1,1}
								 };
	
	static int[][] testMatrix2 = {	{1,1,1,1,1},
									{1,1,1,1,1},
									{1,2,2,2,2},
									{1,1,1,1,1},
									{1,1,1,1,1}
	 };
	
	static int[][] testMatrix3 = {	{1,1,1,1,1},
									{1,4,1,1,1},
									{1,1,4,1,1},
									{1,1,1,4,1},
									{1,1,1,1,4}
								 };
	
	static int[][] testMatrix4 = {	{1,1,1,1,1},
									{1,1,3,1,1},
									{1,1,3,1,1},
									{1,1,3,1,1},
									{1,1,3,1,1}
								 };
	
	static int[][] testMatrix5 = {	{5,1,1,1,1},
									{1,1,1,1,1},
									{1,1,1,1,1},
									{5,1,1,1,1},
									{1,1,1,1,1}
								 };
	
	static int[][] testMatrix6 = {	{1,1,1,1,1,1,1},
									{1,1,1,1,1,1,1},
									{1,1,1,1,1,1,1},
									{1,7,1,1,1,1,1},
									{1,1,7,1,1,1,1},
									{1,1,1,7,1,1,1},
									{1,1,1,1,7,1,1}
								 };
	
	static int[][] testMatrix7 = {	{1,1,2,1,3,1,1},
									{1,1,6,1,3,1,1},
									{1,5,9,7,8,4,1},
									{1,2,4,4,5,1,2},
									{1,6,2,1,1,1,1},
									{1,1,3,4,8,1,1},
									{1,1,6,1,3,1,9}
								 };
	
	static int[][] testMatrix8 = {	{1,1,2,1,3,1,1},
									{1,1,6,1,3,1,1},
									{1,5,2,7,8,4,9},
									{1,2,4,4,5,1,2},
									{1,6,2,1,1,1,1},
									{1,1,3,4,8,1,1},
									{1,1,6,1,3,1,9}
								 };
	
	static int[][] testMatrix9 = {	{1,1,2,1,3,1,1},
									{1,1,6,1,3,1,1},
									{1,5,2,7,8,2,3},
									{1,9,4,4,5,1,2},
									{1,6,2,1,1,1,1},
									{1,7,3,4,8,1,1},
									{1,8,6,1,3,1,9}
								 };
	
	static int[][] testMatrix10 = {	{1,1,2,1,3,1,1},
									{1,1,6,1,3,9,1},
									{1,5,2,7,8,2,3},
									{1,2,4,7,5,1,2},
									{1,4,8,1,1,1,1},
									{1,1,3,4,8,1,1},
									{1,5,6,1,3,1,9}
								 };
								
	Problem11 problem11;
	
	@Before
	public void setUp() {
		problem11 = new Problem11();
	}
	
	@Test
	public void solve() {
		System.out.println(problem11.theMatrix.length + "x" + problem11.theMatrix[0].length);
		
		long result = problem11.findLargestProduct(problem11.theMatrix, 4);
		System.out.println(result);
	}
	
	@Test
	public void  testProduct() {
		long result = problem11.findLargestProduct(testMatrix1, 4);
		assertEquals(1, result);
		
		result = problem11.findLargestProduct(testMatrix2, 4);
		assertEquals(16, result);
		
		result = problem11.findLargestProduct(testMatrix3, 4);
		assertEquals(256, result);
		
		result = problem11.findLargestProduct(testMatrix4, 4);
		assertEquals(81, result);
		
		result = problem11.findLargestProduct(testMatrix5, 4);
		assertEquals(25, result);

		result = problem11.findLargestProduct(testMatrix6, 4);
		assertEquals(2401, result);
		
		result = problem11.findLargestProduct(testMatrix7, 4);
		assertEquals(2520, result);
		
		result = problem11.findLargestProduct(testMatrix8, 4);
		assertEquals(2016, result);
		
		result = problem11.findLargestProduct(testMatrix9, 4);
		assertEquals(3024, result);
		
		result = problem11.findLargestProduct(testMatrix10, 4);
		assertEquals(9*8*7*8, result);
		
	}
}
