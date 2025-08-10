package com.kas.dsasupreme.extra_classes;

import java.util.Stack;

public class ValidParnthesis1 {
	public static boolean validp(char[] ch){
		Stack<Character> st = new Stack<>();
		for(char c:ch){
			if(c == '{' || c == '[' || c == '('){
				st.push(c);
			}
			else{
				if(st.isEmpty()){
					return false;
				}
				if(c == '}'){
					if(st.peek() == '{')
					{
						st.pop();
					}
					else
						return false;
				}
				else if(c == ']'){
					if(st.peek() == '[')
					{
						st.pop();
						}
					else
						return false;
				}
				else{
					if(st.peek() == '(')
						{
						st.pop();
						}
					else
						return false;
				}
			
				}
		}
		return (st.isEmpty());
		
	}

	public static void main(String[] args) {
		String s = "{}";
		//{
		//{}
		//{]}
		//}
		char ch[] = s.toCharArray();
		boolean b = validp(ch);
		System.out.println(b);
	}
}