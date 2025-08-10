package com.kas.dsasupreme.dp;

public class Day111__2_FindWaysTargetSumofArrMem {

	/*static int target = 3;
	static int[] arr = new int[] { 1, 2 };// value
*/	static int target = 4;
	static int[] arr = new int[] { 1, 2 ,3};// value
	static int[] dp = new int[target+1];
	static int countDearr(int targetN) {

		if (targetN == 0)
			return 1;
		if (targetN < 0)
			return 0;
		
		if(dp[targetN] != -1) return dp[targetN]; 
		int ans = 0;
		for (int i = 0; i < arr.length; i++)
			ans = ans + countDearr(targetN - arr[i]);
		
		dp[target] =ans;
		return dp[target];
	}

	public static void main(String[] args) {
		for(int i=0;i<=target;i++)
			dp[i] = -1;
		System.out.println(countDearr(target));
		
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5