package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.List;

public class Day119__2_LongesIncreasingSubseqMem {
	// pos //0, 1,2,3,4
	static int[] ip = new int[] { 5,8,3,7,9,1}; //	
	static int n = ip.length;
	static int[] dp = new int[n+1];
	static List<Integer> op= new ArrayList<Integer>();
	static int countDearr(int curr, int prev) {
		// here if frog reaches to 4 then stop
		//if (prev == -1) return 1;
		if(curr >= n-1) return 0;
		
		if(dp[curr] != -1) return dp[curr];
		int inc =0,exc=0;

		if(prev == -1 || ip[curr] > ip[prev])
		{op.add(ip[curr]);
		inc = 1 + countDearr(curr + 1, curr);
		}
		else
		exc = 0 + countDearr(curr+1, prev);

		return dp[curr] = Math.max(inc, exc);
	}

	public static void main(String[] args) {
		for(int i=0;i<=n;i++)
			dp[i] = -1;
		System.out.println(countDearr(0, -1));
		System.out.println(op);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5