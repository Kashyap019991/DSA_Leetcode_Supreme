package com.kas.dsasupreme.dp;

public class Day102_FiboBottomUpSpaceOpt {

	static int n = 6;
	//step 1
	static int[] dp = new int[n + 1];

	public static void main(String[] args) {
		// step 2
		int prev1 = 1;
		int prev2 = 0;
		
		//step3
		for(int i=2;i<=n;i++)
		{
			int curr = prev1 + prev2;
			prev2=prev1;
			prev1=curr;
		}
		System.out.println(prev1);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5