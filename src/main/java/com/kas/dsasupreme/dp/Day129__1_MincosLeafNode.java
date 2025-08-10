package com.kas.dsasupreme.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day129__1_MincosLeafNode {
	static Map<List<Integer>, Integer> map = new HashMap<>();

	static void maxPairValue(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			map.put(Arrays.asList(i, i), arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				map.put(Arrays.asList(i, j), Math.max(map.get(Arrays.asList(i, j - 1)), arr[j]));
			}
		}

	}

	static int solveRec(int[] arr, int left, int right) {
		// leaf node
		if (left == right)
			return 0;

		int ans = Integer.MAX_VALUE;

		for (int k = left; k < right; k++) {
			int ans1 = (map.get(Arrays.asList(left, k)) * map.get(Arrays.asList(k + 1, right))) + solveRec(arr, left, k)
					+ solveRec(arr, k + 1, right);
			ans = Math.min(ans, ans1);
		}

		return ans;

	}

	public static void main(String[] args) {

		int[] arr = new int[] { 7,12,8,10 };
		maxPairValue(arr);
		System.out.println(solveRec(arr, 0, arr.length - 1));
	}
}
