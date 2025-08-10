package com.kas.dsasupreme.dp;

public class Day111__1_FindWaysTargetSumofArrRec {

	static int target = 3;
	static int[] arr = new int[] { 1, 2 };// value

	static int countDearr(int targetN) {

		if (targetN == 0)
			return 1;
		if (targetN < 0)
			return 0;
		int ans = 0;
		for (int i = 0; i < arr.length; i++)
			ans = ans + countDearr(targetN - arr[i]);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(countDearr(3));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5