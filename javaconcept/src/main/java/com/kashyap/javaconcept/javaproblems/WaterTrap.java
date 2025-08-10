package com.kashyap.javaconcept.javaproblems;

public class WaterTrap {

    public static void main(String[] args) {
        Integer[] height = {3,0,1,0,4,0,2};
        System.out.println(trapWater(height));
    }
    //using 2 pointer
    public static int trapWater(Integer [] height){
        int lMax = 0;
        int rMax = 0;
        int lPointer = 0; // pointer 1
        int rPointer = height.length - 1; // pointer 2
        int water = 0;
        if (height.length < 3){
            return water;
        }

        while (lPointer < rPointer){
            if(height[lPointer] < height[rPointer]){
                if (lMax < height[lPointer]) {
                    lMax = height[lPointer];
                } else {
                    water += (lMax - height[lPointer]);
                }
                lPointer ++;
            } else {
                if (rMax < height[rPointer]){
                    rMax = height[rPointer];
                } else {
                    water += (rMax - height[rPointer]);
                }
                rPointer --;
            }

        }
        return water;
    }
}
