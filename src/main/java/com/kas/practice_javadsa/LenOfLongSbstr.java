package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.Map;

class LenOfLongSbstr {
	/*
	 * public int lengthOfLongestSubstring(String s) { char[] arr = s.toCharArray();
	 * Map<Character,Integer> map = new HashMap<Character,Integer>(); int maxim =
	 * Integer.MIN_VALUE; int l=0; int r=0,n =s.length();
	 * 
	 * for(int i=0;i<n;i++){ if(map.get(arr[i]) == null) { map.put(arr[i], i+1);
	 * r++; maxim =Math.max( maxim,r-l); } else if(map.get(arr[i]) !=null){ l++;
	 * map.put(arr[i],l); }
	 * 
	 * } return maxim;
	 * 
	 * }
	 */
	
	
    public int lengthOfLongestSubstring(String s) {
   char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int maxim = Integer.MIN_VALUE;
        int l=0;
        int maxLen = 0;

    for(int r=0;r<s.length();r++){
            char currChar = arr[r];
            if(map.containsKey(currChar) && map.get(currChar) >= l){
                l = map.get(currChar);
                
                }

            map.put(currChar,r);
            maxLen = Math.max(maxLen,r-l);

        }
return maxLen;
 
    }
public static void main(String[] args) {
	//String s = " ";//"pwwkew";//"abcabcbb";
	
	//LenOfLongSbstr s1 = new LenOfLongSbstr();
	//System.out.println(s1.lengthOfLongestSubstring(s));
	
	
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();


	lis1.add("a");
	list1.add("b");
}

}