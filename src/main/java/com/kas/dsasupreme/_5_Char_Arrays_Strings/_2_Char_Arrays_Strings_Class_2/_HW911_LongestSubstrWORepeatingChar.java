package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _HW911_LongestSubstrWORepeatingChar {
	static String solve(String s) {
		int start = 0;
		int end = 0;
		// String currStr = "";
		String maxStr = "";
		int maxStrLen = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		// s = abba
		while (end < s.length()) {
			if (hm.containsKey(s.charAt(end))) //a n , b n , b y , a y
			{
				start = Math.max(hm.get(s.charAt(end)) + 1, start);// max(2,0) ->2 , max(1,2) -> 2 ow s will be 1 if not max cons with start 
				// currStr = s.substring(start,end+1);// 
				// currStrLen = currStr.length();//3,3,3,3,3
			}
			hm.put(s.charAt(end), end);// a->0,b->1,2
			// currStr = s.substring(start,end+1); (end-start+1)//a , ab ,abc,
			// bca, cab ,abc,bcb, cbb
			// currStrLen = currStr.length(); (end-start+1) //1 , 2 , 3, 3,3,3
			// ,3,3
			if ((end - start + 1) > maxStrLen) {//1>0 ,2>1 , 1 >2n
												// 3>3n,3>3n.3>3n
				maxStr = s.substring(start, end + 1);// a ,ab, 
				maxStrLen = maxStr.length();// 1,2
			}

			end = end + 1;// 1 2 3
		}

		return maxStr;
	}

	public static void main(String[] args) {
		String text1 = "abba"; // "pwwkew"; handele updatind s
								// =hm.get(s.charAt(end))+1//"abcabcbb";
		// String text1 = "abc", text2 = "def"; //ans =0
		System.out.println(solve(text1));
	}
}
