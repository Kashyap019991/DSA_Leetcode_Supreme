package com.kas.dsasupreme.extra_classes;

import java.util.Arrays;

public class sortzot {

static int[] Solution(int[] nums){

	int lo=0,mid=0,hi=nums.length-1,temp;
	
	//for(int i=0;i<nums.length;i++)
	while(mid<=hi)
	{
		
		if(nums[mid] == 0){
			temp =nums[lo];
			 nums[lo]=nums[mid];
			nums[mid]=temp;
			//swap(nums[lo],nums[mid);
			lo++;
			mid++;
			}
		else if(nums[mid] == 1){
			mid++;
			}
		else//2
			{
			temp =nums[hi];
			 nums[hi]=nums[mid];
			nums[mid]=temp;
			//swap(nums[mid],nums[hi]);
			hi--;
			
			}
	}
	return nums;
}

	public static void main(String argos[]) {

		//int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
		int[] nums = new int[] {0,1,1,0,1,2,1,2,0,0,0,1};
		int[] numsRes = Solution(nums);
		System.out.println(Arrays.toString(numsRes));

	}

}
