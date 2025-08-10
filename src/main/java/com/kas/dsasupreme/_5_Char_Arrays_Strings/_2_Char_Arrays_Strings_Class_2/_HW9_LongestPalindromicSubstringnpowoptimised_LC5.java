package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
//https://www.techiedelight.com/longest-palindromic-substring-non-dp-space-optimized-solution/
import java.util.Arrays;

class _HW9_LongestPalindromicSubstringnpowoptimised_LC5 {
    static String exploreAround(String s, int l , int r){
    	
    	while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
    		l--;
    		r++;
    	}
    	return s.substring(l +1 ,r);
    }
    public static  String longestPalindromicSubstrOpt(String s) {
    	int n = s.length();
    	String max_string = "";
    	int max_count_str = 0;
    	for(int center = 0; center < n;center++){
    		//for odd length output
    		String curr_str = exploreAround(s, center , center);
    		if(curr_str.length() > max_count_str )
    		{
    			max_count_str = curr_str.length();
    			max_string = curr_str;
    		}
   
    		//for even length output
    		curr_str = exploreAround(s, center , center+1);
    		if(curr_str.length() > max_count_str )
    		{
    			max_count_str = curr_str.length();
    			max_string = curr_str;
    		}
   
    	}
    	return max_string;
    }
       public static void main(String[] args) {
		String s = "babad";
		
		System.out.println(longestPalindromicSubstrOpt(s));
	}
}