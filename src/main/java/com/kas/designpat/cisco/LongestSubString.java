package com.kas.designpat.cisco;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
	   public int lengthOfLongestSubstring(String s) {
	
	        
	   char[] arr = s.toCharArray();
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        int maxim = Integer.MIN_VALUE;
	        int l=0;
	        int maxLen = 0;
	     for(int r=0;r<s.length();r++){
	    	 char currChar = arr[r];
	            if(!map.containsKey(currChar) || map.get(currChar) < l){  
	        	map.put(s.charAt(r), r);
	        	maxLen = Math.max(maxLen , r-l+1);
	        }
	        else {
	        	l = map.get(s.charAt(r))+1;
	        	map.put(s.charAt(r),r);
	        }
	        
	
	        }
	     return maxLen;
	     
	   }
	   
	   public static void main(String[] args) {
		String s = "abcabcd";
		LongestSubString l = new LongestSubString();
		System.out.println(l.lengthOfLongestSubstring(s));
		
	}
}

