package com.kas.dsasupreme.extra_classes;

public class maxSubArrayProduct {
	static int maxProductSubArrayBrut(int arr[]) {

		/*int n = arr.length;
		int maxi = arr[0];
		int currProd =1;
		// edge case
		if (n == 1)
			return arr[0];
		for(int i=0;i<n;i++){

			//int currProd =1;
			//for(j=i;j<n;j++){
			
				currProd *= arr[i];
				maxi = Math.max(currProd, maxi);
//			}

		}
		currProd =1;
		for(int i=n-1;i>=0;i--){

			
			//for(j=i;j<n;j++){
			
				currProd *= arr[i];
				maxi = Math.max(currProd, maxi);
//			}

		}*/
		
		int n = arr.length;
		int maxi = arr[0];
		int currMin = 1; int currMax =1;
		//edge case
		if(n == 1) return arr[0];
		for(int i=0;i<n;i++){

			if(arr[i] == 0){
				currMin = 1;
				currMax =1;
				continue;
			}
			int tmp = currMax*arr[i];
			currMax = Math.max(arr[i], Math.max(currMin*arr[i], currMax*arr[i]));
			currMin = Math.max(arr[i], Math.max(currMin*arr[i], tmp));
			
			maxi = Math.max(maxi, currMax);
		}
		return maxi;
		/*
		 * if (nums.length == 0) System.out.println(0);
		 * 
		 * int result = Integer.MIN_VALUE;
		 * 
		 * for(int i=0;i<nums.length;i++) { int currPass = 1; for(int
		 * j=i;j<nums.length;j++) { currPass *= nums[j]; result =
		 * Math.max(currPass,result); } } System.out.println(result);
		 */

		/*
		 * if(arr.length ==1) System.out.println(0); int maxi = arr[0]; int
		 * currProd = 1; for(int i=0;i<arr.length;i++) {
		 * 
		 * //for(int j=i;j<arr.length;j++){
		 * 
		 * currProd *= arr[i]; maxi = Math.max(maxi,currProd); //}
		 * 
		 * if(arr[i] == 0) { currProd =1; //continue; }
		 * 
		 * } System.out.println(maxi);
		 */
	}

	private static void maxSubArrayProd(int[] input) {

		/*
		 * int n = input.length; int maxi =Integer.MIN_VALUE;
		 * 
		 * int prod =1; for(int i=0;i<n;i++) {
		 * 
		 * //for(int j=i+1;j<n;j++) {
		 * 
		 * //for(int k = i;k<=j;k++) {
		 * 
		 * prod *= input[i]; //} maxi = Math.max(maxi, prod);
		 * //System.out.println(prod); if(prod ==0) prod=1; //} }
		 * 
		 * prod =1;
		 * 
		 * for(int i=n-1;i>=0;i--){ prod *= input[i]; maxi =Math.max(maxi,
		 * prod);
		 * 
		 * if(prod == 0) prod =1; }
		 */
		int len = input.length;
		if (len == 1)
			System.out.println(input[0]);

		int currMax = 1;
		int currMin = 1;

		int res = Integer.MIN_VALUE;

		for (int i = 0; i < len; i++) {

			int n = input[i];
			// edge case
			if (n == 0) {
				currMax = 1;
				currMin = 1;
				continue;
			}
			int tmp = n * currMax;

			currMax = Math.max(Math.max(tmp, n * currMin), n);
			// we took ,n bcoz if {1,8} case then last elem should consider
			// we took n*currMin bcoz n can be -ve and currMin -ve
			// {-1,-2,-3}=-2(min)*-3
			// we took n*currMax bcoz n can be +ve and currMax can be
			// +ve={-1,-2,3}=2(max)*3
			currMin = Math.min(Math.min(tmp, n * currMin), n);
			// System.out.println(currMax +","+ currMin);
			res = Math.max(currMax, res);

		}
		if (res < 0)
			res = 0;

		// return res;

		System.out.println(res);
	}

	public static void main(String[] args) {
		int[] input = {-1,8};//{2,-3,4};//{2,3,-2,4};//{ -1, 8 };// {3,-1,4};//{-2,0,-1};//{3,-1,4};////{-2};//{-2,0,-1};//{2,3,-2,4};//{-8,5,3,16};//{1,2,-3,0,-4,-5};
		System.out.println(maxProductSubArrayBrut(input));
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
