package com.kashyap.javaconcept.javaproblems;

import org.jetbrains.annotations.NotNull;

public class BinarySearch {

    public static void main(String[] args) {
        Integer [] ar = {1,3,5,7,10,22,32,44,56};
        Integer key = 44;
        System.out.println(serchMethod(ar, key));

    }

    public static Integer serchMethod( Integer [] ar, Integer key){
        Integer low = 0;
        Integer high = ar.length - 1;
        while(low <= high){
            Integer mid = (high + low)/2;
            if(ar[mid] < key){
                low = mid + 1;
            } else if (ar[mid] > key){
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if (low > high) {
          return -1;
        }
        return -1;
    }

}
