package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToEvalParanthesis {

	public static void main(String[] args) {
		String exp= "2-1-1";
		//waysOfEvalExp(exp);
		System.out.println(waysOfEvalExp(exp));
	}

	private static List<Integer> waysOfEvalExp(String exp) {
		List<Integer> ans = new ArrayList<>();
		for(int i=0;i<exp.length();i++) {
			char ch = exp.charAt(i);
			
			if(ch == '+' || ch == '-' || ch == '*')
			{
				List<Integer> left = waysOfEvalExp(exp.substring(0, i));
				List<Integer> right = waysOfEvalExp(exp.substring(i+1));
				
				for(int m:left) {
					for(int n:right) {
						if(ch == '+')
							ans.add(m+n);
						else if(ch == '-')
							ans.add(m-n);
						else
							ans.add(m*n);
					}
				}
			}
			
		}
		if(ans.size()==0)
			ans.add(Integer.valueOf(exp));
		return ans;
		
	}
}

