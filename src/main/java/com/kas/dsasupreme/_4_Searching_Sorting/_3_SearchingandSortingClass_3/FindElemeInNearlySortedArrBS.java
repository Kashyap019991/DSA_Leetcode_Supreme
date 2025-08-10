package com.kas.dsasupreme._4_Searching_Sorting._3_SearchingandSortingClass_3;
//https://leetcode.com/discuss/interview-question/1717779/google-onsite-almost-sorted-array
public class FindElemeInNearlySortedArrBS {

	static int nearlySortedArr(int arr[], int target){
		
		int s =0;
		int e = arr.length -1;
		int mid = 0;
		
		while(s <= e)
		{
			mid = s + (e-s)/2;
			
			if(target== arr[mid])
				return mid;
			else if(target == arr[mid-1])
				return mid-1;
			else if(target == arr[mid + 1])
				return mid + 1;
			else if(target < arr[mid])//left
				e = mid-2;
			else //target > arr[mid]
				s= mid +2;
			
			
		}
		return mid;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,3,40,20,50,80,70};
		int target = 70;
		System.out.println(nearlySortedArr(arr,target));
	}
}
