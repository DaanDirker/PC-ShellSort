package com.company;

import java.util.ArrayList;
import java.util.List;

public class ParallelShellSort {

    private static final int CORES = 4;
    private static int[] array;
    private static int gap;
    private static int arraySize;


    private static void sort() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (gap = arraySize / 2; gap > 0; gap /= 2) {
            int amountThreads = arraySize / gap;
            if (amountThreads > CORES) amountThreads = CORES;

            for (int i = gap; i < arraySize; i += 1) {
                Thread thread = new Thread(new Worker(i));
                threads.add(thread);
                thread.start();
            }

            for (int i = 0; i < threads.size(); i++) {
                threads.get(i).join();
            }
        }
    }

    public static void start(int[] unsortedArray) throws InterruptedException {
        array = unsortedArray;
        arraySize = array.length;
        sort();
    }

    static class Worker implements Runnable {

        int index;

        Worker (int index) {
            this.index = index;
        }

        @Override
        public void run() {
            int temp = array[this.index];
            int j;

            for (j = this.index; j >= gap && array[j - gap] > temp; j -= gap) {
                array[j] = array[j - gap];
            }

            array[j] = temp;
        }
    }
}
