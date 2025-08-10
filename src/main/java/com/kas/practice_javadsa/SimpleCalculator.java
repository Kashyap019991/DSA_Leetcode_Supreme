package com.kas.practice_javadsa;

import java.util.Stack;

class SimpleCalculator {
	 public int calculate(String s) {
	        if(s == null || s.isEmpty()) return 0;
	        int ans =0;
	        int currNum =0;
	        char operation = '+';
	        int len = s.length();
	        Stack<Integer> stack = new Stack<Integer>();
	        for(int i=0;i<len;i++){
	            char currChar = s.charAt(i);
	            if(Character.isDigit(currChar)){
	                currNum = (currNum *10) + (currChar -'0');
	            }
	            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == len-1){
	                if(operation == '+')
	                    stack.push(currNum);
	                else if(operation == '-')
	                    stack.push(-currNum);
	                else if(operation == '*')
	                    stack.push(stack.pop()*currNum);
	                else if(operation == '/')
	                    stack.push(stack.pop()/currNum);

	                operation = currChar;
	                currNum =0;
	            }
	            

	        } 
	        while(!stack.isEmpty()) {
	            ans += stack.pop();
	        }
	        return ans;
	    }
    public static void main(String[] args) {
		String s ="3+2*2";
		SimpleCalculator sl2 = new SimpleCalculator();
		System.out.println(sl2.calculate(s));
	}
}
