package com.kas.dsasupreme.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day129__3_MincosLeafNodeTab {
	static Map<List<Integer>, Integer> map = new HashMap<>();

	static void maxPairValue(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			map.put(Arrays.asList(i, i), arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				map.put(Arrays.asList(i, j), Math.max(map.get(Arrays.asList(i, j - 1)), arr[j]));
			}
		}

	}

	static int solveTab(int[] arr,int[][] dp) {
		int n = arr.length;
		for(int left = n-1;left >=0;left--){
			for(int right = 0;right <= n-1;right++){
				if(left == right) continue;
				else
				{
					int ans = Integer.MAX_VALUE;

					for (int k = left; k < right; k++) {
						int ans1 = (map.get(Arrays.asList(left, k)) * map.get(Arrays.asList(k + 1, right))) 
								+ dp[left][k]
								+ dp[k + 1][right];
						ans = Math.min(ans, ans1);
					}
					dp[left][right] = ans;
				}
			}
		}
		
		return dp[0][n-1];
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 7,12,8,10 };
		int n = arr.length;
		maxPairValue(arr);
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], 0);
		
		System.out.println(solveTab(arr,dp));
	}
}
