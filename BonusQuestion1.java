/*
 * The question we'll work through is the following: return a new sorted merged list from K sorted lists, each with size N. Before we move on any further, you should take some time to think about the solution!

First, go through an example. This buys time, makes sure you understand the problem, and lets you gain some intuition for the problem. For example, if we had [[10, 15, 30], [12, 15, 20], [17, 20, 32]], the result should be [10, 12, 15, 15, 17, 20, 20, 30, 32].
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class BonusQuestion1 {

    public static int multiDemensionalIndices(int[][] NumArrays) {
        
        int totalLength = 0;

        for(int i = 0; i < NumArrays.length; i++) {
            totalLength += NumArrays[i].length;
        }
        return totalLength;
    }

    public static int[] MultiDimensionalSort(int[][] NumArrays) {

        int[] sortedArray = new int[multiDemensionalIndices(NumArrays)];
        int indicesTracker = 0;

        for(int i = 0; i < NumArrays.length; i++){
            for(int j = 0; j < NumArrays[i].length; j++) {
                sortedArray[indicesTracker] = NumArrays[i][j];
                indicesTracker += 1;
            }
        }

        int N = sortedArray.length;
        int M = 0;

        for (int i = 0; i < N; i++) {
            M = Math.max(M, sortedArray[i]);
        }

        int[] countArray = new int[M + 1];

        for (int i = 0; i < N; i++) {
            countArray[sortedArray[i]]++;
        }

        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[sortedArray[i]] - 1] = sortedArray[i];
            countArray[sortedArray[i]]--;
        }

        return outputArray;
    }

  
    public static void main(String[] args) {
        
        int[][] numArrays = new int[][] {{10,15,30},{12,15,20},{17,20,32}};

        int[] sortedArray = MultiDimensionalSort(numArrays);

        System.out.println(Arrays.toString(sortedArray));

    }

 }