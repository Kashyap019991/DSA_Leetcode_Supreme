//https://leetcode.com/problems/sort-an-array/description/

//array passby value not refe https://www.edureka.co/community/6475/is-java-pass-by-reference-or-pass-by-value?show=6481#a6481
//but changes value in same  object 
package com.kas.dsasupreme._7_DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _1_HW_BacktrackingCombinationSumLC39 {

	static void combinationSumHelper(int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans, int index) {
		//base case
		if(target == 0)
		{List<Integer> c= new  ArrayList<>(curr);
		//c = curr;
			ans.add(c);
			return;
		}
		if(target < 0){
			return;
		}
		//if we start i from 0 then it will not give us unieque combination i.e 2,3 and 3,2 not acceptable
		for(int i=index;i<candidates.length;i++){
			curr.add(candidates[i]);
			combinationSumHelper(candidates, target - candidates[i], curr, ans, i);
			curr.remove(curr.size()-1);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<>();
		int index = 0;
		combinationSumHelper(candidates, target, curr, ans, index);
		return ans;
	}
	//static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		int[] ip = new int[] { 2, 3, 5 };
		int target = 5;

		List<List<Integer>> ans = combinationSum(ip, target);
		for(List<Integer> ls : ans){
			for(int i:ls){
				System.out.print(i);
			}
			System.out.println();
		}
	}
}