package com.kashyap.javaconcept.javaproblems;


import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        Integer[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }

    private List<List<Integer>> threeSum(Integer[] nums) {
        Arrays.sort(nums);// sort array to handle duplicates
        List<List<Integer>> result = new java.util.ArrayList<>();
        for (Integer i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // skip duplicates for the first element
            }

            Integer left = i + 1; // second element
            Integer right = nums.length - 1; // third element
            while (left < right) {
                Integer sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // skip duplicates for the second element
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return result;
    }
}
