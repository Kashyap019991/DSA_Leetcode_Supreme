package com.kas.dsasupreme.dp;

public class Day121__3_Pizza3nSliceBUTabSopt {
	// pos //0, 1,2,3,4
	//static int[] slices = new int[] {1,2,3,4,5,6}; // ans =10
	
	//static int[] slices = new int[] { 8, 9, 8, 6, 1, 1 }; // ans=16
	static int[] slices = new int[]{9,5,1,7,8,4,4,5,5,8,7,7};//ans =30

	
	
	static int countDearr() {
		int k = slices.length;
		int[] next1 = new int[k+2]; //ind+2 
		int[] curr1 = new int[k+2]; //index+1
		int[] prev1 = new int[k+2]; //ind
		for(int i=0;i<k+2;i++){
			next1[i] = 0;
			curr1[i] =0;
			prev1[i] = 0;
		}

		int[] next2 = new int[k+2]; //ind+2 
		int[] curr2 = new int[k+2]; //index+1
		int[] prev2 = new int[k+2]; //ind
		for(int i=0;i<k+2;i++){
			next2[i] = 0;
			curr2[i] =0;
			prev2[i] = 0;
		}

		for(int index = k-2;index>=0;index--)
		{
			for(int n=1;n<=k/3;n++){
				int inc = slices[index] + next1[n - 1];
				int exc = 0 + curr1[n];
				prev1[n] = Math.max(inc, exc);
			}
			next1 = curr1.clone();
			curr1 = prev1.clone();
			
		} 
		int first = curr1[k / 3];

		for(int index = k-1;index>=1;index--)
		{
			for(int n=1;n<=k/3;n++){
				int inc = slices[index] + next2[n - 1];
				int exc = 0 + curr2[n];
				prev2[n] = Math.max(inc, exc);
			}
			next2 = curr2.clone();
			curr2 = prev2.clone();
		}
		int last = curr2[k / 3];
		return Math.max(first, last);

	}

	public static void main(String[] args) {
		// include 1st so skip last
		System.out.println(countDearr());
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5