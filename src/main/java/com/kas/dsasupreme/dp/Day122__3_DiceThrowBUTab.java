package com.kas.dsasupreme.dp;

public class Day122__3_DiceThrowBUTab {
	static int N = 3,M=2,X=6; //ans =1
	//static int N = 30,M=30,X=500; //ans =1
	static int[][] dp = new int[N+1][X+1];
	static int mod=(int)(1e9+7);
	static int countDearr(int dice,int faces,int target) {
	
		//if(dice == 0 && target == 0) return 1;
		dp[0][0] = 1;
		
		for(int d = 1;d<=dice;d++)
		{
			for(int t = 1;t<=target;t++){
				int ans = 0;
				for(int i=1;i<=faces;i++){
					if(t-i >=0)
					ans = (ans+ dp[d-1][t - i])%mod;
				}
				dp[d][t] = ans;
			}
			
		}
		
		return dp[dice][target];
	}

	public static void main(String[] args) {
		for(int i = 0; i<=N; i++){
			for(int j=0;j<=X;j++)
				dp[i][j] = 0;
		}	
		System.out.println(countDearr(N, M, X));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5