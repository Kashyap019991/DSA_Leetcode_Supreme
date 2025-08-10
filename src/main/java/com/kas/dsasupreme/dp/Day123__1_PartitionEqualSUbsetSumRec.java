package com.kas.dsasupreme.dp;

public class Day123__1_PartitionEqualSUbsetSumRec {
	

	static Boolean countDearr(int index,int target,int[] nums,int n) {
	
		if(target < 0) return false;
		if(index >= n) return false;
		if(target == 0) return true;
		
		
		Boolean	inc = countDearr(index+1, target - nums[index],nums,n);
		Boolean	exc = countDearr(index+1, target - 0,nums,n);
		
		return inc || exc;
	}

	public static void main(String[] args) {
		//int[] nums = new int[]{1,5,11,5};
		int[] nums = new int[]{1,2,3,5};
		int total =0;
		for(int i=0;i<nums.length;i++)
			total = total + nums[i];
		if((total | 1) <= total) //bcoz for even no. it will be > means +1
			return;
		total = total/2;
		
		System.out.println(countDearr(0,total,nums,nums.length));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5