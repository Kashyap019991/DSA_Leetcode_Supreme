package com.kas.dsasupreme.dp;
//sc --> o(m)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
public class Day115__4_MaximalSquareSpcOpt {

	static int[][] ip = new int[][] { { 1, 1 }, { 1, 1 } };
	//static int[][] ip = new int[][]{{0,1},{1,0}};
	//static int[][] ip = new
	//int[][]{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
	static int maxim = 0;
	static int m = ip.length;// row
	static int n = ip[0].length; // cols
	

	static int countDearr() {
		int[] curr = new int[n+1];
		int[] next = new int[n+1];
		for(int i=0;i<=n;i++){
			curr[i] = 0;
			next[i] = 0;
		}
		// if (j >= ip[0].length || i >= ip.length) return 0;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int right = curr[j + 1];
				int diagnal = next[j + 1];
				int down = next[j];

				if (ip[i][j] == 1) {
					curr[j] = 1 + Math.min(right, Math.min(diagnal, down));
					maxim = Math.max(maxim, curr[j]);

				} else
					curr[j] = 0;
			}
			next = curr;
		}
		return curr[0];
	}

	public static void main(String[] args) {
	

		countDearr();
		System.out.println(maxim);
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5