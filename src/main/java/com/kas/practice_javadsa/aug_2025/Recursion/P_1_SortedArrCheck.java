package com.kas.practice_javadsa.aug_2025.Recursion;

public class P_1_SortedArrCheck {
    public boolean isSorted(int[]  arr, int index){
        if(arr.length == 0 || index == arr.length-1)
            return true;

        if(arr[index] > arr[index+1])
            return false;

        return isSorted(arr,index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new P_1_SortedArrCheck().isSorted(arr,0));
    }
}
