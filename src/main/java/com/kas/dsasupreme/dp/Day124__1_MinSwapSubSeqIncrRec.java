package com.kas.dsasupreme.dp;

public class Day124__1_MinSwapSubSeqIncrRec {

	static int count = 0;

	/*static void countDearr1(int[] nums1, int[] nums2, int index) {

		if (index + 1 == nums1.length)
			return;

		// int prev1 = nums1[index-1];
		// int prev2 = nums2[index-1];
		// int ans = 999999;
		
		 * if(swapped == 1) { int temp = prev1; prev1 = prev2; prev2 = temp; }
		 

		// no swap

		
		 * if(nums1[index] > prev1 && nums2[index] > prev2) ans =
		 * countDearr(nums1, nums2, index+1,0);
		 
		int ans = 99999999;
		if (nums1[index] < nums1[index + 1] && nums2[index] < nums2[index + 1])
			countDearr1(nums1, nums2, index + 1);
		else
		// swap below if for [0,4,4,5,9]
		// [0,1,6,8,10] here ans will be 2 but should be 1
		// if(nums1[index] > prev2 && nums2[index] > prev1)
		{
			int temp = nums1[index];
			nums1[index] = nums2[index];
			nums2[index] = temp;
			count = count + 1;
			countDearr1(nums1, nums2, index + 1);
		}
		//return ans;

	}*/
	 static int countDearr(int[] nums1,int[] nums2,int index,int swapped) {
			
			if(index == nums1.length) return 0;
			
			int prev1 = nums1[index-1];
			int prev2 = nums2[index-1];
			int ans = 999999;
			if(swapped == 1) {
				int temp = prev1;
				prev1 = prev2;
				prev2 = temp;
			}
			
			
			//no swap
			
			if(nums1[index] > prev1 && nums2[index] > prev2)
				ans = countDearr(nums1, nums2, index+1,0);
			
			//swap
			if(nums1[index] > prev2 && nums2[index] > prev1)
					ans = Math.min(ans,1+countDearr(nums1, nums2, index+1, 1));
			
			return ans;
		}
	public static void main(String[] args) {
		//int[] nums = new int[]{1,5,11,5};
		/*int[] nums1 = new int[]{1,2,3,8};
		int[] nums2 = new int[]{5,6,7,4}; // ans 1
*/		
		/*int[] nums1 = new int[]{0,4,4,5,9};
		int[] nums2 = new int[]{0,1,6,8,10};*/ //ans 1
		
				
						
		/*int[] nums1 = new int[]{0,3,5,8,9};
		int[] nums2 = new int[]{2,1,4,6,9};*/ //ans =1
		
		int[] nums1 = new int[]{3,3,8,9,10};
		int[] nums2 = new int[]{1,7,4,6,8};
		
		
		int[] newn1 = new int[nums1.length+1];
		newn1[0]=-1;
		for(int i=0;i<nums1.length;i++){
			newn1[i+1] = nums1[i];
		}
		
		int[] newn2 = new int[nums1.length+1];
		newn2[0]=-1;
		for(int i=0;i<nums2.length;i++){
			newn2[i+1] = nums2[i];
		}
		
		System.out.println(countDearr(newn1, newn2, 1,0));
 	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5