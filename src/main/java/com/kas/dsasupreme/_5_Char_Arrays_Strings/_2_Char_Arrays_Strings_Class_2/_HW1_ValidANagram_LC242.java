package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

public class _HW1_ValidANagram_LC242 {
	    public static boolean isAnagram(String s, String t) {
	        int[] freqTable = new int[256];
	        Arrays.fill(freqTable,0);
	        for(int i=0;i<s.length();i++){
	            freqTable[s.charAt(i)] = freqTable[s.charAt(i)] +1;
	            //System.out.println(freqTable[s.charAt(i)]);
	        }
	        for(int i=0;i<t.length();i++){
	            freqTable[t.charAt(i)] = freqTable[t.charAt(i)]-1;
	        }
	        System.out.println(freqTable['a']);
	        for(int i=0;i<freqTable.length;i++){
	            if(freqTable[i] !=0)
	                return false;
	                
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(isAnagram("anagram","nagaram"));
		}
	
}
