/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */

import java.util.Arrays;

public class DailyCodingProblem2 {
    

    public static int[] ArrayMinusI(int[] inputArray){
        int[] resultArray = new int[inputArray.length];
        int sum = 1;

        for(int i = 0; i < inputArray.length; i++) {
            for(int j = 0; j < inputArray.length; j++) {
                if(j == i) {
                    continue;
                } else {
                    sum *= inputArray[j];
                }
                
            } 
            resultArray[i] = sum;
            sum = 1;
        }



        return resultArray;


    }


    public static void main(String[] args) {

        int[] inputArray = {3, 2 ,1};
        int[] resultArray = (ArrayMinusI(inputArray));

        System.out.println(Arrays.toString(resultArray));
        
    }
}
