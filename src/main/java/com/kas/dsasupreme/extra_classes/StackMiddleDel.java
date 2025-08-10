package com.kas.dsasupreme.extra_classes;

import java.util.Stack;

public class StackMiddleDel{
	
	public static void Solve(Stack<Integer> s,int count,int size)
	{
		if(count == size/2){
			s.pop();
			return;
		}
		
		int num = s.peek();
		s.pop();
		Solve(s,count+1,size);
		s.push(num);
		
	}
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		int size = 5;
		int count = 0;
		Solve(s,count,size);
		System.out.println(s);
	}
}