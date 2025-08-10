package com.kas.dsasupreme.dp;

import java.util.Arrays;

public class Day120__1_MaxHeightByStackingCuboidOptF {
	// pos //0, 1,2,3,4
	//static int[][] ip = new int[][] { { 50, 45, 20 }, { 95, 37, 53 }, { 45, 23, 12 } }; // 190
	//static int[][] ip = new int[][] { {38,25,45},{76,35,3} }; // 76
	//static int[][] ip = new int[][] { {7,11,17},{7,17,11},{11,7,17},{11,17,7},
	//{17,7,11},{17,11,7}};  //ans=102
	//static int[][] ip = new int[][] { {35,32,11},{7,6,65},{3,39,41}};//65
	static int[][] ip = new int[][]{{92,47,83},{75,20,87},{68,12,83},{12,85,15},
		{16,24,47},{69,65,35},{96,56,93},{89,93,11},
		{86,20,41},{69,77,12},{83,80,97},{90,22,36}}; //ans 447
	static int n = ip.length;
	static int[][] dp = new int[n + 1][n + 1];

	static Boolean check(int[] base, int[] newBox) {
		if (newBox[0] <= base[0] && newBox[1] <= base[1] && newBox[2] <= base[2])
			return true;
		else
			return false;
	}

	static int countDearr() {
		// sort each row for low to high
		for (int[] cuboid : ip) {
			Arrays.sort(cuboid);
		}
		//x?y:z
		// sort cuboids basis on w or l
		//Arrays.sort(ip, (a, b) -> Integer.compare(a[1], b[1]));
		Arrays.sort(ip, 
                (x, y) -> y[2] == x[2] 
                            ? y[1] == x[1] 
                                ? x[0] - y[0] 
                                : x[1] - y[1] 
                            : x[2] - y[2]);
		int[] curr = new int[n + 1];
		int[] next = new int[n + 1];

		// same logic of LIS
		for (int i = 0; i <= n; i++) {
			curr[i] = 0;
			next[i] = 0;
		}

		for (int currInd = n - 1; currInd >= 0; currInd--) {
			
			for (int prevInd = currInd - 1; prevInd >= -1; prevInd--) {
				int inc = 0;
				if (prevInd == -1 || check(ip[currInd], ip[prevInd])) {
					// height sum
					inc = ip[currInd][2] + next[currInd + 1];
				}
					int exc = 0 + next[prevInd + 1];

				curr[prevInd + 1] = Math.max(inc, exc);
				// op.add(ip);
			}
			next = curr;

		}
		return next[0];
	
	}

	public static void main(String[] args) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				dp[i][j] = 0;
		}

		System.out.println(countDearr());
		// System.out.println(op);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5