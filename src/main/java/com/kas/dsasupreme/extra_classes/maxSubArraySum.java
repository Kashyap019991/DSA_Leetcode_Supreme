package com.kas.dsasupreme.extra_classes;

public class maxSubArraySum {

	private static void maxSubArraySum(int[] input) {
		
			int n = input.length;
			int maxi =Integer.MIN_VALUE;
			int  sum =0;
			for(int i=0;i<n;i++) {
				
				//for(int j=i+1;j<n;j++) {
					
					//for(int k = i;k<=j;k++) {
						
						sum += input[i];
					//}
					maxi = Math.max(maxi, sum);
					
					if(sum <0)
						sum=0;
				//}
			}
			System.out.println(maxi);
	}

	public static void main(String[] args) {
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		maxSubArraySum(input);
	}

}
