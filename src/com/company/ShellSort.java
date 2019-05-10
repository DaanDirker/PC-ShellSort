package com.company;

class ShellSort {

    static int[] sort(int[] array) {
        int inner, outer, temp;
        int arraySize = array.length;

        int interval = 1;
        while (interval <= arraySize / 3) {

            // Define an interval sequence
            interval = interval * 3 + 1;

            // Keep looping until the interval is 1
            // Then this becomes an insertion sort
            while (interval > 0) {

                // Continue incrementing outer until the end of the array is reached
                for (outer = interval; outer < arraySize; outer++) {

                    // Store the value of the array in temp unless it has to be
                    // copied to a space occupied by a bigger number closer to the
                    // beginning of the array
                    temp = array[outer];

                    // inner is assigned the value of the highest index to check
                    // against all values the proceed it. Along the way if a
                    // number is greater than temp it will be moved up in the array
                    inner = outer;

                    // While there is a number bigger than temp move it further
                    // up in the array
                    while (inner > interval - 1 && array[inner - interval] >= temp) {
                        array[inner] = array[inner - interval];
                        inner -= interval;
                    }

                    // Now that everything has been moved into place put the value
                    // stored in temp into the index above the first value smaller
                    // than it is
                    array[inner] = temp;

                }

                // Once we get here we have interval sorted our array
                // so we decrement interval and go again
                interval = (interval - 1) / 3;
            }
        }
        return array;
    }
}
