package com.kas.dsasupreme._9_Stack;

import java.util.Arrays;
import java.util.Stack;

class _Class3_2_LongestValidParenthesisLenLC_32 {

	public static int longestValidParentheses(String s) {
		
		int maxLen =0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '(')
			{
				st.push(i);
			}
			else{
				st.pop();
				//if its ending bracket and its empty
				
				if(st.isEmpty()){
					st.push(i);
				}
				else{ //if its not empty
					int len =  i -st.peek() ;
					maxLen = Math.max(len, maxLen);
				}
			}
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		String ip = "(()";
		System.out.println(longestValidParentheses(ip));
	}
}