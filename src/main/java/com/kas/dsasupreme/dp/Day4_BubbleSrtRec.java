package com.kas.dsasupreme.dp;

public class Day4_BubbleSrtRec {
	static int a[] = { 3, 2, 8, 1, 5 };

	static void swap(int i, int j) {
		int temp = 0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int n = a.length;

	/*
	 * static void bubblrSrt() { for(int i = 1;i<n;i++){ for(int j=0;j<n-i;j++){
	 * if(a[j]>a[j+1]){ swap(j,j+1); } } }
	 */
	static void bubblrSrtRec(int j) {
		if (j == 0)
			return;
		for (int i = 0; i < j - 1; i++) {
			if (a[i] > a[i + 1]) {
				swap(i, i + 1);
			} 
				bubblrSrtRec(j - 1);
			
		}
	}

	// Driver method
	public static void main(String[] args) {

		bubblrSrtRec(5);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
// 412
// 41
// 4
// 0
// 1 2 3 4 5