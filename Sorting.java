/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorting;

/**
 *
 * @author asus
 */
public class Sorting {
public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array before sorting:");
        printArray(array);
        System.out.println("");
        
        System.out.println("\nArray After Sorting using :");

        // Bubble Sort
        bubbleSort(array.clone());
        System.out.println("-Bubble Sort:");
        printArray(array);
        System.out.println("");

        // Insertion Sort
        insertionSort(array.clone());
        System.out.println("\n-Insertion Sort:");
        printArray(array);
        System.out.println("");

        // Selection Sort
        selectionSort(array.clone());
        System.out.println("\n-Selection Sort:");
        printArray(array);
        System.out.println("");
        
        // Merge Sort
        mergeSort(array.clone(), 0, array.length - 1);
        System.out.println("\n-Merge Sort:");
        printArray(array);
        System.out.println("");

        // Quick Sort
        quickSort(array.clone(), 0, array.length - 1);
        System.out.println("\n-Quick Sort:");
        printArray(array);
        System.out.println("");
    }

    // Bubble Sort
    static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of array[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Selection Sort
    static void selectionSort(int[] array) {
        int n = array.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;

            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Merge Sort
    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    static void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temporary arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temporary arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        /* Merge the temporary arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // pi is partitioning index, array[pi] is now at right place
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);  // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Function to print an array
    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    } 
}
