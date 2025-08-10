package com.kas.dsasupreme.dp;

public class Day122__2_DiceThrowTDPMem {
	//static int N = 3,M=2,X=6; ans =1
	static int N = 30,M=30,X=500; //ans =1
	static int[][] dp = new int[N+1][X+1];
	static int mod=(int)(1e9+7);
	static int countDearr(int dice,int faces,int target) {
	
		if(target < 0) return 0;
		if(dice == 0 && target != 0) return 0;
		if(dice != 0 && target ==0) return 0;
		if(dice == 0 && target == 0) return 1;
		if(dp[dice][target] !=  -1) return dp[dice][target];
		int ans = 0;
		for(int i=1;i<=faces;i++){
			ans = (ans+ countDearr(dice-1, faces, target - i))%mod;
		}
		
		return dp[dice][target] = ans;
	}

	public static void main(String[] args) {
		for(int i = 0; i<=N; i++){
			for(int j=0;j<=X;j++)
				dp[i][j] = -1;
		}	
		System.out.println(countDearr(N, M, X));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5