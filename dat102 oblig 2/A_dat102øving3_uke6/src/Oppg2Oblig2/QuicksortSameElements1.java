package Oppg2Oblig2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class QuicksortSameElements1 {
	
	public static void main(String[] args) {
	int[] sizes = {32000, 64000, 128000};

    System.out.println("Resultat Kvikksortering - Like elementer:");
    printResults(true, sizes,1);

    //System.out.println("\nResultat Kvikksortering - Tilfeldig distribuert:");
    //printResults(false, sizes);
}

// Implementasjon av QuickSort
public static void quickSort(int[] arr) {
    Arrays.sort(arr);
}

// Genererer en tabell med like elementer eller tilfeldig distribuerte elementer
private static int[] generateArray(int size, boolean sameElements) {
    int[] array = new int[size];
    Random random = new Random();

    if (sameElements) {
        int value = random.nextInt();
        Arrays.fill(array, value);
    } else {
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
    }

    return array;
}

// Måling av tid og utskrift av resultater
private static void printResults(boolean sameElements, int[] sizes, int measurements) {
    for (int size : sizes) {
    	for (int measurement = 1; measurement <= measurements; measurement++ ) {
        int[] array = generateArray(size, sameElements);
        int[] copyArray = Arrays.copyOf(array, array.length);

        // Start tidtakning
        long startTime = System.nanoTime();

        // Kjør Quicksort på arrayet
        quickSort(copyArray);

        // Slutt tidtakning
        long endTime = System.nanoTime();

        // Beregn total tid og gjennomsnittstid
        long elapsedTime = endTime - startTime;
        double averageTime = (double) elapsedTime / 1_000_000; // Convert nanoseconds to milliseconds

        // Utskrift av resultater
        System.out.printf("N=%d | Antall målinger = 1 | Målt tid (gjennomsnitt)=%.2f ms | Teoretisk tid c*f(n)\n", size, averageTime);

    }    
    	System.out.println();
    }

}
}