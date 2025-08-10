package com.kashyap.javaconcept.javaproblems;

public class CompressString {
    public static void main(String[] args){
        String s = "aaaabbcccddeeeeaaabbbbbcc";
        String compressedString = "";
        int count = 1;
        String[] arr = s.split("");
        for(int i =1; i < arr.length; i ++){
            if(arr[i].equals(arr [i-1])){
                count += 1;
            }else{
                compressedString = compressedString + arr[i -1] + count;
                count = 1;
            }
        }
        compressedString = compressedString + arr[arr.length -1] + count;
        System.out.println(compressedString);

    }
}
