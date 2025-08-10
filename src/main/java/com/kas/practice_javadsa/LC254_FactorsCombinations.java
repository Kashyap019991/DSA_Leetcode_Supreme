package com.kas.practice_javadsa;

import java.util.LinkedList;
import java.util.*;
public class LC254_FactorsCombinations {
//backTracking
	static void btrack(LinkedList<Integer> factors,List<List<Integer>> ans) {
		if(factors.size() >1)
		{
			ans.add(new ArrayList(factors));
		}
		
		int lF = factors.removeLast();
		
		for(int i=factors.isEmpty()?2:factors.peekLast();i<=lF/i;i++) {
			if(lF%i ==0) {
				factors.add(i);
				factors.add(lF/i);
				
				btrack(factors,ans);
				
				factors.removeLast();
				factors.removeLast();
				
			}
		}
		factors.add(lF);
	}
	public static void main(String[] args) {
		
		int n=12;
		List<List<Integer>> ans  = new LinkedList();
		btrack(new LinkedList(Arrays.asList(n)),ans);
		
		System.out.println(ans);
	}
}
