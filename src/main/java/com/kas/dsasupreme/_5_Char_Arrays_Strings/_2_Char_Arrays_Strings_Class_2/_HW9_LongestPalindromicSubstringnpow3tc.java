package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

class _HW9_LongestPalindromicSubstringnpow3tc {
    static Boolean isPalindrome(String t,int i,int j){
    	int start = i;
    	int end = j;
    	while(start < end){
    		if(t.charAt(start) != t.charAt(end) )
    			return false;
    	start++;end--;
    	}
    	return true;
    }
    public static  String longestPalindromicSubstr(String s) {
    	int n = s.length();
    	String ans = "";
    	for(int i=0;i<n;i++)
    	{
    		
    		for(int j=i;j<n;j++){
    			//StringBuilder t = new StringBuilder("");
//    			for(int k =i;k<=j;k++)
//    			{
//    				t.append(s.charAt(k));
//    			}
    			//System.out.println(ans);
    			
    			//System.out.println(i +" " + j);
    			//		t=s.substring(i, j+1);
    			if(isPalindrome(s,i,j)){
    				//check size is > prev max ans
    				String t=s.substring(i, j+1);
    				ans = t.length() > ans.length() ? t : ans;
    			}
    		}
    	}
    	return (ans);
    }
       public static void main(String[] args) {
		String s = "a";
		
		System.out.println(longestPalindromicSubstr(s));
	}
}