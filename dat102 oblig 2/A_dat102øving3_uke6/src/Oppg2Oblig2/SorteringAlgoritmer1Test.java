package Oppg2Oblig2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SorteringAlgoritmer1Test {
	
	@Test
	void testInsertionSort() {
		Integer[] array = {4, 2, 7, 1, 9, 3};
		Integer[] expected = {1, 2, 3, 4, 7, 9};
		
		SorteringAlgoritmer1.insertionSort(array);
		
		assertArrayEquals(expected, array);
	}
	
	@Test
	void testSelectionSort() {
		Integer[] array = {8, 5, 3, 9, 1, 4, 7, 6, 2};
		Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		SorteringAlgoritmer1.insertionSort(array);
		
		assertArrayEquals(expected, array);
	}
	
	@Test
	void testQuickSort() {
		Integer[] array = {4,2,7,1,9,3};
		Integer[] expected = {1, 2, 3, 4, 7, 9};
		
		SorteringAlgoritmer1.quickSort(array, 0, array.length - 1);
		
		assertArrayEquals(expected, array);
		
	}
	
	@Test
	void testMergeSort() {
		Integer[] array = {8, 5, 3, 9, 1, 4, 7, 6, 2};
		Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		SorteringAlgoritmer1.mergeSort(array, 0, array.length - 1);
		
		assertArrayEquals(expected, array);
	}
	

}
