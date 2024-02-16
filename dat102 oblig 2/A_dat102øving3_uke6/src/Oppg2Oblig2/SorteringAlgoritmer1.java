package Oppg2Oblig2;

import java.util.Arrays;
import java.util.Random;

public class SorteringAlgoritmer1 {
	 // Sortering ved innsetting
    public static void insertionSort(Integer[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Utvalgssortering
    public static void selectionSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Kvikksortering
    public static void quickSort(Integer[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(Integer[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Flettesortering
    public static void mergeSort(Integer[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(Integer[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Integer[] leftArray = Arrays.copyOfRange(array, left, left + n1);
        Integer[] rightArray = Arrays.copyOfRange(array, mid + 1, mid + 1 + n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    

    public static void main(String[] args) {
    	 int[] n = {32000, 64000, 128000};
         int measurements = 3;

         Random random = new Random();

         // Kvikksortering
         System.out.println("Resultat for Kvikksortering :");
         System.out.println("N        | Antall målinger | Målt tid (gjennomsnitt) | Teoretisk tid c*f(n)");
         for (int size : n) {
             Integer[] array = new Integer[size];
             for (int i = 0; i < size; i++) {
                 array[i] = random.nextInt();
             }

             long totalTime = 0;
             for (int i = 0; i < measurements; i++) {
                 long time = measureTime(array, "quickSort");
                 totalTime += time;
             }
             double averageTime = (double) totalTime / measurements / 1_000_000; // Konverter nanosekunder til millisekunder
             System.out.printf("%6d | %17d | %24.2f | %22s%n", size, measurements, averageTime, "");

         }

         // Sortering ved innsetting
         System.out.println("\nResultat for sortering ved innsetting:");
         System.out.println("N        | Antall målinger | Målt tid (gjennomsnitt) | Teoretisk tid c*f(n)");
         for (int size : n) {
             Integer[] array = new Integer[size];
             for (int i = 0; i < size; i++) {
                 array[i] = random.nextInt();
             }

             long totalTime = 0;
             for (int i = 0; i < measurements; i++) {
                 long time = measureTime(array, "insertionSort");
                 totalTime += time;
             }
             double averageTime = (double) totalTime / measurements / 1_000_000; // Konverter nanosekunder til millisekunder
             System.out.printf("%6d | %17d | %24.2f | %22s%n", size, measurements, averageTime, "");
         }

         // Utvalgssortering
         System.out.println("\nResultat for utvalgssortering:");
         System.out.println("N        | Antall målinger | Målt tid (gjennomsnitt) | Teoretisk tid c*f(n)");
         for (int size : n) {
             Integer[] array = new Integer[size];
             for (int i = 0; i < size; i++) {
                 array[i] = random.nextInt();
             }

             long totalTime = 0;
             for (int i = 0; i < measurements; i++) {
                 long time = measureTime(array, "selectionSort");
                 totalTime += time;
             }
             double averageTime = (double) totalTime / measurements / 1_000_000; // Konverter nanosekunder til millisekunder
             System.out.printf("%6d | %17d | %24.2f | %22s%n", size, measurements, averageTime, "");
         }

         // Flettesortering
         System.out.println("\nResultat for flettesortering:");
         System.out.println("N        | Antall målinger | Målt tid (gjennomsnitt) | Teoretisk tid c*f(n)");
         for (int size : n) {
             Integer[] array = new Integer[size];
             for (int i = 0; i < size; i++) {
                 array[i] = random.nextInt();
             }

             long totalTime = 0;
             for (int i = 0; i < measurements; i++) {
                 long time = measureTime(array, "mergeSort");
                 totalTime += time;
             }
             
             double averageTime = (double) totalTime / measurements / 1_000_000; // Konverter nanosekunder til millisekunder
             System.out.printf("%6d | %17d | %24.2f | %22s%n", size, measurements, averageTime, "");
         }
    }
    

     public static long measureTime(Integer[] array, String sortingAlgorithm) {
         long startTime = System.nanoTime();

         switch (sortingAlgorithm) {
             case "insertionSort":
                 insertionSort(array.clone());
                 break;
             case "selectionSort":
                 selectionSort(array.clone());
                 break;
             case "quickSort":
                 quickSort(array.clone(), 0, array.length - 1);
                 break;
             case "mergeSort":
                 mergeSort(array.clone(), 0, array.length - 1);
                 break;
             default:
                 throw new IllegalArgumentException("Invalid sorting algorithm");
         }

         long endTime = System.nanoTime();
         return endTime - startTime;
     }
 }