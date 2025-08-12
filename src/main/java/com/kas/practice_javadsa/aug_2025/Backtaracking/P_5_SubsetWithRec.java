package com.kas.practice_javadsa.aug_2025.Backtaracking;

import java.util.ArrayList;
import java.util.List;

public class P_5_SubsetWithRec {
    static List<String> subsets = new ArrayList<>();
    StringBuilder subset = new StringBuilder();
    public void findSubset(String inp, int ind){

        if(ind == inp.length()) {
            subsets.add(subset.toString());

            return;
        }
        subset.append(inp.charAt(ind));
        findSubset(inp,ind+1);

        //not include
        subset.deleteCharAt(subset.length()-1);
        findSubset(inp,ind+1);
    }

    public static void main(String[] args) {
        String inp = "abc";
        new P_5_SubsetWithRec().findSubset(inp,0);
        System.out.println(subsets);
    }
}
