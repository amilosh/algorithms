package sorting;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public static void arraySortComplexity(int numberElements) {
        int[] worstArray = generateWorstArray(numberElements);
        int[] randomArray = generateRandomArray(numberElements);

        burbleSort1(worstArray.clone());
        burbleSort1(randomArray.clone());

        burbleSort2(worstArray.clone());
        burbleSort2(randomArray.clone());

        selectionSort(worstArray.clone());
        selectionSort(randomArray.clone());
    }

    // burble sort 1
    // O(n^2)
    public static void burbleSort1(int[] arr) {
        print(arr);

        long iterations = 0;
        long swaps = 0;

        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 0; i < arr.length - 1; i++) {
                iterations++;
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    swaps++;
                    needIteration = true;
                }
            }
        }

        print(arr);
        printComplexity(iterations, swaps);
    }

    // burble sort 2
    // O((n^2)/2)
    public static void burbleSort2(int[] arr) {
        print(arr);

        long iterations = 0;
        long swaps = 0;

        int last = arr.length - 1;
        for (int j = last; j >= 1; j--) {
            for (int i = 0; i <= j - 1; i++) {
                iterations++;
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    swaps++;
                }
            }
        }

        print(arr);
        printComplexity(iterations, swaps);
    }

    // selection sort
    // O((n^2)/2)
    public static void selectionSort(int[] arr) {
        print(arr);

        long iterations = 0;
        long swaps = 0;

        int last = arr.length - 1;
        for (int i = 0; i <= last - 1; i++) {
            int minElement = i;
            for (int j = i + 1; j <= last; j++) {
                iterations++;
                if (arr[j] <= arr[minElement]) {
                    minElement = j;
                }
            }
            int minValue = arr[minElement];
            arr[minElement] = arr[i];
            arr[i] = minValue;
            swaps++;
        }

        print(arr);
        printComplexity(iterations, swaps);
    }

    public static int[] generateWorstArray(int numberElements) {
        int[] arr = new int[numberElements];
        int last = numberElements - 1;
        for (int i = 0; i <= last; i++) {
            arr[i] = numberElements--;
        }
        return arr;
    }

    public static int[] generateRandomArray(int numberElements) {
        Random rand = new Random();
        int[] arr = new int[numberElements];
        int last = numberElements - 1;
        for (int i = 0; i <= last; i++) {
            arr[i] = rand.nextInt(numberElements) + 1;
            ;
        }
        return arr;
    }

    public static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printComplexity(long iterations, long swaps) {
        System.out.println("Iterations: " + iterations + ", swaps: " + swaps);
    }
}
