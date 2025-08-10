package com.kas.dsasupreme.dp;

public class Day140__4_RevWordInString {

	// int S = 10; // no. of days to survive
	// int N = 16; // max food buy each day
	// int M = 2; // required food each day

	static String revWord(String s) {
		StringBuilder temp = new StringBuilder();
		String ans = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && temp.length() !=0) {
				
				ans = ans + temp.reverse().toString();
				ans = ans + " ";
				temp = new StringBuilder();
			} else {
				if(s.charAt(i) != ' ')
				temp.append(s.charAt(i));
			}

		}
		ans = ans + temp.reverse().toString();
		ans = ans.trim(); // remove edge spaces
		ans = ans.replaceAll(" +", " "); // remove multiple spaces
		return ans;

		/*
		 * String[] str=s.trim().split("\s+"); String ans=""; for(int
		 * i=str.length-1;i>=0;i--){ ans += str[i]+" ";
		 * 
		 * }
		 */
	}

	public static void main(String[] args) {
		String s = "   fffff ff gg ee";
		//String s ="a good   example";
		//String s = "  hello world  ";
		//String s = "the sky is blue";
		System.out.println(revWord(s));
	}
}
