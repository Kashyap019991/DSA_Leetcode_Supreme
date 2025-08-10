package com.kas.dsasupreme.extra_classes;

import java.util.Stack;

/**
 * Input: s = "()[]{}"
Output: true
 * @author Krishna
 *
 */
public class ValidParanthesis {

	public static void main(String[] args) {
		String s = "()[]s}";
		//String s = "(]";
		//String s = "]";
		char[] charr = s.toCharArray();
		
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0;i<charr.length;i++){
		char tp =charr[i];
			if(tp == '(' || tp == '[' || tp == '{')
			st.push(charr[i]);
			else if (tp == ')' && !st.isEmpty())
			{
				if(st.peek() == '(')
					st.pop();
				else
					System.out.println(false);
			}
			else if (tp == '}' && !st.isEmpty())
			{
				if(st.peek() == '{')
					st.pop();
				else
					System.out.println(false);
			}
			else if (tp == ']'  && !st.isEmpty())
			{
				if(st.peek() == '[')
					st.pop();
				else
					System.out.println(false);
			}
			else
				{System.out.println(false);
				return;}
			
		}
		if(st.isEmpty())
		System.out.println("true");
	}
}
