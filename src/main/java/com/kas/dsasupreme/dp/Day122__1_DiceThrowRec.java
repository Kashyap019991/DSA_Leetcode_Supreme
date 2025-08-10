package com.kas.dsasupreme.dp;

public class Day122__1_DiceThrowRec {
	static int N = 3,M=2,X=6; //ans=1
	
	static int mod=(int)(1e9+7);
	static int countDearr(int dice,int faces,int target) {
	
		if(target < 0) return 0;
		if(dice == 0 && target != 0) return 0;
		if(dice != 0 && target ==0) return 0;
		if(dice == 0 && target == 0) return 1;
		int ans = 0;
		for(int i=1;i<=faces;i++){
			ans = (ans+ countDearr(dice-1, faces, target - i))%mod;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		System.out.println(countDearr(N, M, X));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5