package com.kas.dsasupreme.dp;

public class Day110_1_KnapSack01_Rec {
	// for circular house , first is nebr of last
	// or same as MaxSumNn adj
	static int n = 4;// {0,1,2} ==> {1,0,2},{2,1,0},------
	static int capacity = 5;
	static int[] w = new int[] { 1, 2, 4, 5 };// weight
	static int[] v = new int[] { 5, 4, 8, 6 };// value
	static final int MOD = 1000000007;

	static int countDearr(int indx, int capac) {

		if (indx == 0) {
			if (w[0] <= capac)
				return v[0];
			else
				return 0;
		}
		int inc = 0;
		if(w[indx] <= capac)
			inc = v[indx] + countDearr(indx-1, capac - w[indx]);
		
		int exc = 0 + countDearr(indx-1, capac);
		
		int ans = Math.max(inc, exc);
		
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(countDearr(n - 1, capacity));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5