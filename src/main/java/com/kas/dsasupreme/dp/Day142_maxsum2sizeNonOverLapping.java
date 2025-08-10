package com.kas.dsasupreme.dp;

public class Day142_maxsum2sizeNonOverLapping {

	public static void main(String[] args) {

		int[] arr = new int[] { 2,1,5,6,0,9,5,0,3,8 };
		System.out.println(maxSumTwoNoOverlap(arr, 4, 3));
	}

	static int maxSumTwoNoOverlap(int[] A, int L, int M) {
		return Math.max(maxSum(A, L, M), maxSum(A, M, L));
	}

	private static int maxSum(int[] A, int L, int M) {
		int sumL = 0, sumM = 0;
		for (int i = 0; i < L + M; i++) {
			if (i < L) {
				sumL += A[i];
			} else {
				sumM += A[i];
			}
		}
		//int ans = sumM + sumL;
		int maxL = sumL;
		int ans = sumL + sumM;
		for (int i = L + M; i < A.length; i++) {
			sumM += A[i] - A[i - M];
			sumL += A[i - M] - A[i - L - M];
			maxL = Math.max(maxL, sumL);
			//if like below then will be overlaped
			//maxM = Math.max(maxL, sumM);
			//so consider overall sum
			ans = Math.max(ans, maxL + sumM);
		}
		

		return ans;
	}
}