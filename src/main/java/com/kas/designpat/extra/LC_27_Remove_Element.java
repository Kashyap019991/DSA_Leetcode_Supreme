package com.kas.designpat.extra;


public class LC_27_Remove_Element{
	public static void main(String[] args) {
		int[] nums = {3,2,2,3};//in place removal
		int val = 3;
		
		System.out.println(removeElem(nums,val));
	}

	private static int removeElem(int[] nums, int val) {
		
		int i=0;
		
		for(int j=0;j< nums.length;j++) {
			if(nums[j] !=val) {
				nums[i] =nums[j];
				i++;
			}
		}
		return i;
		
		
	}
	
}