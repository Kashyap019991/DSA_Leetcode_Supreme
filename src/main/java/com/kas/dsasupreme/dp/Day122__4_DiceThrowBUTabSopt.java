package com.kas.dsasupreme.dp;

public class Day122__4_DiceThrowBUTabSopt {
	static int N = 3,M=2,X=6; //ans =1
	//static int N = 30,M=30,X=500; //ans =1
	//static int[][] dp = new int[N+1][X+1];
	static int mod=(int)(1e9+7);
	static int countDearr(int dice,int faces,int target) {
	
		int[] prev = new int[target+1];
		int[] curr = new int[target+1];
		for(int i = 0; i<=target; i++){
				prev[i] = 0;
				curr[i] =0;
		}	
		//if(dice == 0 && target == 0) return 1;
		prev[0] = 1;
		
		for(int d = 1;d<=dice;d++)
		{
			for(int t = 1;t<=target;t++){
				int ans = 0;
				for(int i=1;i<=faces;i++){
					if(t-i >=0)
					ans = (ans+ prev[t - i])%mod;
				}
				curr[t] = ans;
			}
			prev =curr.clone();
		}
		
		return prev[target];
	}

	public static void main(String[] args) {
		System.out.println(countDearr(N, M, X));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5