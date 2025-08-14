package com.kashyap.javaconcept.javaproblems;

import java.util.HashMap;
import java.util.Map;

public class VariableSizeSlidingWindow {

    public static void main(String[] args) {
        String s = "asdfghajklqwertyauiopzxcvbnm"; // Example input string
        Map<Character, Integer>  charIndexMap = new HashMap<>();
        Integer leftPointer = 0;
        Integer maxLength = 0;
        for (Integer rightPointer = 0; rightPointer< s.length(); rightPointer++){
            Character c = s.charAt(rightPointer);
            if(charIndexMap.containsKey(c)){
                // If the character is already in the map, we need to move the left pointer
                leftPointer = Math.max(leftPointer, charIndexMap.get(c) + 1);
            }
            charIndexMap.put(c, rightPointer);

            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
        }
System.out.println("The length of the longest substring without repeating characters is: " + maxLength);
    }
}
