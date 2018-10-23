package pkgGame;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {

	private void PrintStars() {
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		System.out.println();
	}

	@Test
	public void Sudoku_Test1() {

		try {
			Sudoku s1 = new Sudoku(9);
		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test(expected = Exception.class)
	public void Sudoku_Test2() throws Exception {

		Sudoku s1 = new Sudoku(10);

	}

	@Test
	public void getRegion_Test1() {

		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int[] ExpectedRegion = { 3, 4, 1, 2 };

		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region 0 = 1 2 3 4
		// region 1 = 3 4 1 2

		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);

			region = s1.getRegion(1);
			System.out.println(Arrays.toString(region));
			assertTrue(Arrays.equals(ExpectedRegion, region));

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	public void getRegion_Test2() {

		int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		int[] ExpectedRegion = { 2, 1, 4, 3 };

		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region at 0,2 = 2 1 4 3

		int[] region;
		try {
			Sudoku s1 = new Sudoku(puzzle);

			region = s1.getRegion(0, 2);
			System.out.println(Arrays.toString(region));
			assertTrue(Arrays.equals(ExpectedRegion, region));

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	public void Sudoku_test1() {
		int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertTrue(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}

	@Test
	public void Sudoku_test2() {
		int[][] puzzle = { { 5, 5, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		try {
			Sudoku s1 = new Sudoku(puzzle);
			assertFalse(s1.isSudoku());

		} catch (Exception e) {
			fail("Test failed to build a Sudoku");
		}

	}


	/*
	@Test
	public void isValidColumnValuetest() throws Exception {
		int[][] mySquare = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		Sudoku s = new Sudoku(mySquare);
		assertFalse(s.isValidColumnValue(2, 1));
	}

	@Test
	public void isValidColumnValuetest2() throws Exception {
		int [][] mySquare = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,4,3,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku su=new Sudoku(mySquare);
		assertTrue(su.isValidColumnValue(7,11));
	}
	
	@Test
	public void isValidRowValuetest() throws Exception {
		int[][] mySquare = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		Sudoku sud = new Sudoku(mySquare);
		assertFalse(sud.isValidRowValue(2, 1));
	}

	@Test
	public void isValidRowValuetest2() throws Exception {
		int [][] mySquare = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,4,3,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku sudo=new Sudoku(mySquare);
		assertTrue(sudo.isValidRowValue(7,11));
	}
	
	@Test
	public void isValidRegionValueTest() throws Exception {
		int[][] mySquare = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 } };
		Sudoku sudok=new Sudoku(mySquare);
		assertFalse(sudok.isValidRegionValue(1,2,3));
	}
	
	@Test 
	public void isValidRegionValueTest2() throws Exception {
		int [][] mySquare = {{5,3,4,6,7,8,9,1,2},{6,7,2,1,9,5,4,3,8},{1,9,8,3,4,2,5,6,7},{8,5,9,7,6,1,4,2,3},{4,2,6,8,5,3,7,9,1},{7,1,3,9,2,4,8,5,6},{9,6,1,5,3,7,2,8,4},{2,8,7,4,1,9,6,3,5},{3,4,5,2,8,6,1,7,9}};
		Sudoku sudoku = new Sudoku(mySquare);
		assertTrue(sudoku.isValidRegionValue(8,3,11));
	}
	
	*/
	@Test
	public void testSudoku3() throws Exception {
		Sudoku puzzle = new Sudoku(9);
		puzzle.PrintPuzzle();
		assertTrue(puzzle.isSudoku());
	}
	
/*	
	@Test
	public void testSudoku() throws Exception {
		//tests for randomness by calculating the number of times each number appears in the first cell of region 1
		//if puzzle was generated randomly, these numbers would be quite different from each other
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int count5=0;
		int count6=0;
		int count7=0;
		int count8=0;
		int count9=0;
		for (int i=1; i<=10000; i++) {
		Sudoku puzzle = new Sudoku(9);
		switch (puzzle.getPuzzle()[0][3]) {
			case 1: count1++;
				break;
			case 2: count2++;
				break;
			case 3: count3++;
				break;
			case 4: count4++;
				break;
			case 5: count5++;
				break;
			case 6: count6++;
				break;
			case 7: count7++;
				break;
			case 8: count8++;
				break;
			default: count9++;
				break;
		}
		}
		System.out.println("number of ones = "+count1);
		System.out.println("number of twos = "+count2);
		System.out.println("number of threes = "+count3);
		System.out.println("number of fours = "+count4);
		System.out.println("number of fives = "+count5);
		System.out.println("number of sixes = "+count6);
		System.out.println("number of sevens = "+count7);
		System.out.println("number of eights = "+count8);
		System.out.println("number of nines = "+count9);
	}
	
	@Test
	public void testSudoku2() throws Exception {
		//tests for randomness by calculating the number of times each number appears second to last cell of the final row
		//if puzzle was generated randomly, these numbers would be quite different from each other
		//tests do take a bit of time to complete
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int count5=0;
		int count6=0;
		int count7=0;
		int count8=0;
		int count9=0;
		for (int i=1; i<=10000; i++) {
		Sudoku puzzle = new Sudoku(9);
		switch (puzzle.getPuzzle()[8][7]) {
			case 1: count1++;
				break;
			case 2: count2++;
				break;
			case 3: count3++;
				break;
			case 4: count4++;
				break;
			case 5: count5++;
				break;
			case 6: count6++;
				break;
			case 7: count7++;
				break;
			case 8: count8++;
				break;
			default: count9++;
				break;
		}
		}
		System.out.println("number of ones = "+count1);
		System.out.println("number of twos = "+count2);
		System.out.println("number of threes = "+count3);
		System.out.println("number of fours = "+count4);
		System.out.println("number of fives = "+count5);
		System.out.println("number of sixes = "+count6);
		System.out.println("number of sevens = "+count7);
		System.out.println("number of eights = "+count8);
		System.out.println("number of nines = "+count9);
	}
	*/
}
