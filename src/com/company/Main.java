package com.company;

public class Main {

    public static void main(String[] args) {
        int datasetAmount = 10;

        for (int i = 0; i < datasetAmount; i++) {
            System.out.println("Dataset number " + (i + 1) +":");

            int[] array = generateRandomArray(10000, 1, 80);
            System.out.println("Generated array:");
            printArray(array);

            int[] sortedArray = array;
            long startTime = System.nanoTime();
            sortedArray = ShellSort.sort(array);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            System.out.println("\nSorted array:");
            printArray(sortedArray);

            System.out.println();
            System.out.println("Time spent sorting the array: " + elapsedTime + "\n");
        }
    }

    public static int[] generateRandomArray(int arraySize, int min, int max) {
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * ((max - min) + 1)) + min;
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
