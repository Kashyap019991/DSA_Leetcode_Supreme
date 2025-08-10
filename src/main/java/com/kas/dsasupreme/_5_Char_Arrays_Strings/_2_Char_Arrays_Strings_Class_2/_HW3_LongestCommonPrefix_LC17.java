package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

public class _HW3_LongestCommonPrefix_LC17 {
	
	
	    public static String longestCommonPrefix(String[] strs) {
	        	// 1st string all chars
			int i = -1;
			Boolean match = true;
			StringBuilder sb = new StringBuilder();
			for (char ch : strs[0].toCharArray()) {
				i++;
				// rest of all string 1ast chars
				for (int j = 1; j < strs.length; j++) {
					if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
						match = false;
						break;
					}
					
				}
				if (match == false)
					break;
				else
					sb.append(ch);
			}
			return sb.toString();
	    }
	
	    public static void main(String[] args) {
			System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
		}
	
}
