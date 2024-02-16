package Oppg2Oblig2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class QuicksortSameElements1Test {
	
	@Test
	void testQuickSortSameElements() {
		int[] array = {5, 5, 5, 5, 5, 5};
		int[] expected = {5, 5, 5, 5, 5 ,5};
		
		QuicksortSameElements1.quickSort(array);
		
		assertArrayEquals(expected, array);
	}

}
