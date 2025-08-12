package com.kas.practice_javadsa.aug_2025;

import java.util.HashMap;

class LC_3_LongestSubstrWoRepChar {
    public int lengthOfLongestSubstring(String s) {
        int maxLength =0, left =0,n =s.length();
        HashMap<Character,Integer> posMap = new HashMap<Character,Integer>();
        for(int right=0;right<n;right++){
            if(posMap.containsKey(s.charAt(right)))
            {
                left = Math.max(left,posMap.get(s.charAt(right))+1);
            }
            maxLength = Math.max(maxLength,right-left+1);
            posMap.put(s.charAt(right),right);
        }
        return maxLength; 
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LC_3_LongestSubstrWoRepChar().lengthOfLongestSubstring(s));
    }
}