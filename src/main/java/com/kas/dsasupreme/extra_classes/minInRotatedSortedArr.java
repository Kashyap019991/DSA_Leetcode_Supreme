package com.kas.dsasupreme.extra_classes;

public class minInRotatedSortedArr {
	static int minSortedRotatedArray(int arr[]) {
		
		//{5,1,2,3,4} 
		//l=0,r=4, m=2
		
	/*	if(arr.length ==0) return -1;
		if(arr.length ==1) return arr[0];
		//already sorted
		if(arr[mid] > arr[left] &&arr[mid] < arr[right]
			return arr[0];
		int left =0;
		int right = arr.length -1;

		while(left < right)
		{
			int mid = left +(right -left)/2;
			
			if(mid > 0 && arr[mid] < arr[mid-1]){
				return arr[mid];
			}
			//here >= for [2,1] case
			if(arr[mid] >= arr[left] && arr[mid] > arr[right])
			{
				left = mid +1;
			}
			//if(arr[mid] > arr[left] && arr[mid]  < arr[right])
			if(arr[mid] > arr[left] || arr[mid] < arr[right])
			{
				right = mid -1;
			}
		}*/

		int left = 0;
		int right = arr.length-1;
		int n = arr.length;

		if(n == 0) return -1;
		if(n == 1) return arr[0];

		while(left <= right){

int mid = left +(right -left)/2;
			System.out.print("mid"+mid + " ");
			if(mid > 0 && arr[mid] < arr[mid-1]){
				return arr[mid];
			}
			
			//here >= for [2,1] case
			if(arr[mid] >= arr[left] && arr[mid] > arr[right])
			{
				left = mid +1;
				System.out.print("left"+left);
				System.out.println("right"+right);
			}	
			//if(arr[mid] > arr[left] && arr[mid]  < arr[right])
			if(arr[mid] < arr[right])
			{
				right = mid -1;
				//break;
				/*
				 * System.out.print("left"+left); System.out.println("right"+right);
				 */
				
			}
		}
		return arr[left];
	}//l=0,r=4,m=2 --> 
	public static void main(String[] args) {
		int[] input = {4,5,6,7,0,1,2};//{3,4,5,1,2};//{11,13,15,17};//{5,1,2,3,4};//{4,5,1,2,3};//{2,1};//{11,13,15,17};//{3,4,5,1,2};//{4,5,6,7,0,1,2};//{5,1,2,3,4};
		System.out.println(minSortedRotatedArray(input));
	}

	public int maxProduct(int[] nums) {

		int n = nums.length;

		int maxProduct = Integer.MIN_VALUE;

		// applying Kadane's algo from Left to Right

		int currProd_Left_to_Right = 1;

		for (int i = 0; i < n; i++) {
			currProd_Left_to_Right *= nums[i];

			maxProduct = Math.max(maxProduct, currProd_Left_to_Right);

			if (currProd_Left_to_Right == 0) {
				currProd_Left_to_Right = 1;
			}

		}

		// applying Kadane's algo from Right to Left

		int currProd_Right_to_Left = 1;

		for (int i = n - 1; i >= 0; i--) {
			currProd_Right_to_Left *= nums[i];

			maxProduct = Math.max(maxProduct, currProd_Right_to_Left);

			if (currProd_Right_to_Left == 0) {
				currProd_Right_to_Left = 1;
			}

		}

		return maxProduct;
	}

}
