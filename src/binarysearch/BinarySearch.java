/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarysearch;

import java.util.Random;

/**
 *
 * @author DaTho7561
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = new int[1000];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(1000);
        }
        quicksort(array);
        
        System.out.println(binarySearch(array, 3));
        
    }
    
    /**
     * This version of the quicksort function is used to sort entire array
     * @param array
     */
    public static void quicksort(int[] array) {
        qSort(array, 0, array.length-1);
    }
    
    /**
     * Sorts the array recursively in the specified area.
     * @param array The array to sort
     * @param bottom The bottom (inclusive) of area to sort
     * @param top The top (inclusive) of the area to sort
     */
    public static void qSort(int[] array, int bottom, int top) {
        
        // If the partition is more than one element long
        // partition it and recursively sort it
        if (top-bottom > 0) {
        
            // The pivot is selected arbitrarily to be the top element in the array
            // This doesn't show up in the code, because it is assumed that it's
            // position is "top" and its value is "array[top]"
            
            // Used to figure out where to place the pivot
            // after partitioning is complete, and where to swap elements to
            // for them to be considered part of the partition
            int bottomOfPartition = top;
            
            // Partition the array //
            
            // Iterate through the array from the top to the bottom,
            // which is apparantly the convention for sorting
            for (int i = top; i > bottom-1; i--) {
                // If the current value is more than the pivot
                // (the array can be sorted in reverse order by switching the
                // greater than sign to a lesser than sign)
                if (array[i] > array[top]) {
                    // Swap the value into the bottom of the partition
                    // and update the postition of the bottom of the partition
                    bottomOfPartition--;
                    swap(array, bottomOfPartition, i);
                }
            }
            
            // Put the pivot into place
            swap(array, bottomOfPartition, top);
            
            // Recursivley sort the array //
            // Notice how the pivot is not included in the recursive calls
            
            // Bottom half
            qSort(array, bottom, bottomOfPartition-1);
            
            // Top half
            qSort(array, bottomOfPartition+1, top);
        
        }
        
    }
    
    /**
     * Swaps the position of two values in an array.
     * pre: An array and two valid indices are passed.
     * post: elements swapped.
     * @param array The array to switch the values in
     * @param index1 The index of the first value to be swapped
     * @param index2 The index of the second value to be swapped
     */
    public static void swap(int[] array, int index1, int index2) {
        int val1 = array[index1];
        array[index1] = array[index2];
        array[index2] = val1;
    }
    
    /**
     * Binary search over the entire array.
     * @param array
     * @param value
     * @return The index
     */
    public static int binarySearch(int[] array, int value) {
        return bSearch(array, value, 0, array.length-1);
    }
    
    /**
     * Binary search.
     * @param array
     * @param value
     * @param bottom
     * @param top
     * @return The index
     */
    public static int bSearch(int[] array, int value, int bottom, int top) {
        
        int median = (top+bottom)/2;
        
        if (array[median] == value) {
            return median;
        } else if (bottom > top) {
            return -1;
        } else if (array[median] > value) {
            return bSearch(array, value, bottom, median-1);
        } else {
            return bSearch(array, value, median+1, top);
        }
        
    }
    
}
