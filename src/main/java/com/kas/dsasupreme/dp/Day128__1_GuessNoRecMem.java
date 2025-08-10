package com.kas.dsasupreme.dp;

public class Day128__1_GuessNoRecMem {
	//Mem
    static int solveRecMem(int start,int end,int[][] dp){
        //no number pending
        if(start >= end) return 0;
        
        if(dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            ans = Math.min(ans, i + Math.max(solveRecMem(start,i-1,dp), solveRecMem(i+1,end,dp)));
        }
        return dp[start][end] = ans;
    }

	
	public static void main(String[] args) {

		int n = 10;
		int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }
        
		System.out.println(solveRecMem(1,n,dp)); //ans =16
	}
}
