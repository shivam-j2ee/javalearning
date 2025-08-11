package com.kashyap.javaconcept.javaproblems;

public class FixedSizeSlidingWindow {

    public static void main(String[] args) {
        Integer[] ar = {3,2,4,7,8,0,4,5};
        System.out.println(findMaxSumSubArray(ar, 3));
    }

    private static Integer findMaxSumSubArray(Integer [] ar, Integer windowSize){
        Integer maxSum = 0;
        Integer windowSum = 0;

        if(ar.length < windowSize){
            return -1;
        }
        for(Integer i = 0; i < windowSize; i++ ){
            windowSum += ar[i];
        }
        maxSum = windowSum;
        for(Integer i = windowSize; i < ar.length ; i++){
            //i - windowSize first element
            //i new element
            windowSum += (ar[i] - ar[i - windowSize]);
            maxSum = Math.max(maxSum, windowSum);
        }


        return maxSum;
    }
}
