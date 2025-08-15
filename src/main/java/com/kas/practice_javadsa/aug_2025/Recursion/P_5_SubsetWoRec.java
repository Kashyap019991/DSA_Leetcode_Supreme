package com.kas.practice_javadsa.aug_2025.Recursion;

import java.util.ArrayList;
import java.util.List;

public class P_5_SubsetWoRec {
    public static List<List<Integer>> findAllSubsets(int[] arr) {
        List<List<Integer>> subSeq = new ArrayList();
        int n = arr.length;
        int numberOfSubsets = 1 << n;
        for (int i = 0; i < numberOfSubsets; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                System.out.println(i+" ,"+", "+j+" , "+(i & (1 << j)));
                //check jth bit bit in i == 1 then !=0 o/p or else ==0 o/p
                if ((i & (1 << j)) != 0) {
                    ;
                    list.add(arr[j]);
                    System.out.println(list);
                }
            }
            subSeq.add(list);
        } //O(n^2)
        return subSeq;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> subsets = findAllSubsets(numbers);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
