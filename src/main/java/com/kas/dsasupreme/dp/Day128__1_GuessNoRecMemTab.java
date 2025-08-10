package com.kas.dsasupreme.dp;

public class Day128__1_GuessNoRecMemTab {
	static int solveTab(int n){
        //no number pending
        //if(start >= end) return 0;
        int[][] dp = new int[n+2][n+2];
        for(int i = 0; i<= n+1; i++){
            for(int j=0; j<= n+1;j++){
                dp[i][j] = 0;
            }
        }
        
        for(int start = n; start >=1;start--){
            for(int end = start; end<= n ;end++){
                if(start == end)
                    continue;
                else
                {
                    int ans = Integer.MAX_VALUE;
                    for(int i=start;i<=end;i++){
                        ans = Math.min(ans, i + Math.max(dp[start][i-1], dp[i+1][end]));
                    }
                    dp[start][end] = ans;        
                }
            }
        }
        return dp[1][n];
    }

	
	public static void main(String[] args) {

		int n = 10;
		
        
		System.out.println(solveTab(n)); //ans =16
	}
}
