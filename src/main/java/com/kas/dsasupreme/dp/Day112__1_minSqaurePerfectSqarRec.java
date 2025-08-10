package com.kas.dsasupreme.dp;

public class Day112__1_minSqaurePerfectSqarRec {

	static int n = 5;
	

	static int countDearr(int n) {

		if (n == 0)
			return 0;
		if(n<=0)
			return Integer.MAX_VALUE;
		int ans = n;
		for (int i = 1; i*i <= n; i++)
			ans = Math.min(ans, 1+countDearr(n - i*i));
		return ans;
		
	}

	public static void main(String[] args) {
		System.out.println(countDearr(n));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5