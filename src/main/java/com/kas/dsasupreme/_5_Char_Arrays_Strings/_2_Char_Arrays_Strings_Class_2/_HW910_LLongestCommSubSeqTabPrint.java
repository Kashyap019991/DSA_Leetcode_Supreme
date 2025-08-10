package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
import java.util.*;
public class _HW910_LLongestCommSubSeqTabPrint {
    static int solve(String s) {
    	 int[] c = new int[128]; //To keep count of character in strings
         int[] cIndex = new int[128]; // To keep track of index of character in strings
         int startingWindow = 0;
         int currLen = 0;
         int maxLen = 0;
         String maxString = "";
         int i = 0;
         while(i < s.length()){
             c[s.charAt(i)] += 1;
             while(c[s.charAt(i)]>1){
                 startingWindow = Math.max(startingWindow,cIndex[s.charAt(i)]+1); 
                 c[s.charAt(i)] -= 1;
             }
             cIndex[s.charAt(i)] = i;
             currLen = i-startingWindow+1;
             maxLen = Math.max(currLen,maxLen);
             i++;
         }
         //System.out.println(s.substring(startingWindow,currLen+1));
         return maxLen;
    }

    public static void main(String args[]) {
        String str = "abcabcbb";
        System.out.println("The length of the longest substring without repeating characters is " + solve(str));

    }
}