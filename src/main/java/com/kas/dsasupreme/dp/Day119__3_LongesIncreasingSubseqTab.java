package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.List;

public class Day119__3_LongesIncreasingSubseqTab {
	// pos //0, 1,2,3,4
	static int[] ip = new int[] { 5, 8, 3, 7, 9, 1 }; //
	static int n = ip.length;
	static int[][] dp = new int[n+1][n+1];
	

	static int countDearr() {
		// here if frog reaches to 4 then stop
		// if (prev == -1) return 1;
		/*if (curr >= n - 1)
			return 0;
*/

		
		for(int curr = n-1; curr >=0;curr--){
			List<Integer> op = new ArrayList<Integer>();
			for(int prev=curr-1;prev>=-1;prev--){
				int inc = 0, exc = 0;
				if (prev == -1 || ip[curr] > ip[prev]) {
															
					inc = 1 + dp[curr + 1][ curr+1];
				} else
					exc = 0 + dp[curr + 1][ prev+1];

				dp[curr][prev+1] = Math.max(inc, exc);
				//op.add(ip);
			}
			System.out.println(op);
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		for (int i = 0; i <= n; i++)
		{	
			for(int j=0;j<=n;j++)
			dp[i][j]= 0;
		}
		
		System.out.println(countDearr());
		//System.out.println(op);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5