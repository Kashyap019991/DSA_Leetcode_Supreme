package com.kas.practice_javadsa;

import java.util.Stack;

class LongestValidParen {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
    	String s = ")()())";
        LongestValidParen sl = new LongestValidParen();
        
        sl.longestValidParentheses(s);
	}
    
}
