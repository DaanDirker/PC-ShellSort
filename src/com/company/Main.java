package com.company;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        int datasetAmount = 10;
        ShellSort shellSort = new ShellSort();
        for (int i = 0; i < datasetAmount; i++) {
            System.out.println("Dataset number " + (i + 1) +":");

            int[] array = generateRandomArray();
//            System.out.println("Generated array:");
//            printArray(array);
            long startTime = System.nanoTime();
            shellSort.sort(array);
            long endTime = System.nanoTime();
            long timeInMillis = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);

//            System.out.println("\nSorted array:");
//            printArray(array);

            System.out.println();
            System.out.println("Time spent sorting the array: " + timeInMillis + " ms\n");
        }
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] array = new int[100000];
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
