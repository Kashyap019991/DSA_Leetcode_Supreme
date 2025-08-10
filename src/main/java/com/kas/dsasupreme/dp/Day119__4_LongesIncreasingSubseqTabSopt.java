package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.List;

public class Day119__4_LongesIncreasingSubseqTabSopt {
	// pos //0, 1,2,3,4
	static int[] ip = new int[] { 5, 8, 3, 7, 9, 1 }; //
	static int n = ip.length;
	static int[][] dp = new int[n+1][n+1];
	

	static int countDearr() {
		int[] curr = new int[n+1];
		int[] next = new int[n+1];
		
		for(int i=0;i<=n;i++)
		{
			curr[i] =0;
			next[i] = 0;
		}
		
		for(int currInd = n-1; currInd >=0;currInd--){
			List<Integer> op = new ArrayList<Integer>();
			for(int prevInd=currInd-1;prevInd>=-1;prevInd--){
				int inc = 0, exc = 0;
				if (prevInd == -1 || ip[currInd] > ip[prevInd]) {
															
					inc = 1 + next[ currInd+1];
				} else
					exc = 0 + next[ prevInd+1];

				curr[prevInd+1] = Math.max(inc, exc);
				//op.add(ip);
			}
			next = curr;
			
		}
		return next[0];
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