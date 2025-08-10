package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWoRepeatingChar {
    Map<Character,Integer> charsVsIndMap = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        //abcabcbb  --> abd
        int maxSubStr=0;
        int start =0;
        int end =start;
        
        for(int i=0;i<s.length();i++){
            if(!charsVsIndMap.containsKey(s.charAt(i))){
                charsVsIndMap.put(s.charAt(i),i);
                
                
                //abba==> a->0 ,b->1,2

                //1-0=1
            }
            else{
                int ind = charsVsIndMap.get(s.charAt(i));
                if(ind>=start)
                start = ind+1;//skip from curr str
                charsVsIndMap.put(s.charAt(i),i);
            }
            
            maxSubStr =Math.max(maxSubStr,end-start+1);
            end++;
        }
        return maxSubStr;
        
    }
    public static void main(String[] args) {
		String str ="abba";
		LongestSubstringWoRepeatingChar sl = new LongestSubstringWoRepeatingChar();
		System.out.println(sl.lengthOfLongestSubstring(str));
	}
}