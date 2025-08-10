package com.kas.dsasupreme.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day129__2_MincosLeafNodeMem {
	static Map<List<Integer>, Integer> map = new HashMap<>();

	static void maxPairValue(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			map.put(Arrays.asList(i, i), arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				map.put(Arrays.asList(i, j), Math.max(map.get(Arrays.asList(i, j - 1)), arr[j]));
			}
		}

	}

	static int solveRecMem(int[] arr, int left, int right, int[][] dp) {
		// leaf node
		if (left == right)
			return 0;

		if (dp[left][right] != -1)
			return dp[left][right];
		
		int ans = Integer.MAX_VALUE;

		for (int k = left; k < right; k++) {
			int ans1 = (map.get(Arrays.asList(left, k)) * map.get(Arrays.asList(k + 1, right)))
					+ solveRecMem(arr, left, k, dp) + solveRecMem(arr, k + 1, right, dp);
			ans = Math.min(ans, ans1);
		}
		dp[left][right] = ans;
		return dp[left][right];

	}

	public static void main(String[] args) {

		int[] arr = new int[] { 7,12,8,10 };
		int n = arr.length;
		maxPairValue(arr);
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);

		System.out.println(solveRecMem(arr, 0, arr.length - 1, dp));
	}
}
