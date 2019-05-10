package com.company;

public class Main {

    public static void main(String[] args) {
        int[] firstArray = generateRandomArray(30, 1, 80);
        System.out.println("Generated array:");
        printArray(firstArray);

        System.out.println("\nAfter Sorting:");
        firstArray = ShellSort.sort(firstArray);
        printArray(firstArray);
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
