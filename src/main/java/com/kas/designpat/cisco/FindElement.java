package com.kas.designpat.cisco;

//

//https://programs.programmingoneonone.com/2021/02/hackerrank-java-anagrams-solution.html?m=1
public class FindElement {

	public static void main(String[] args) {
		// 1 2 3 4 5
		// 3-1=2 ans
		// 1 2 1 3 2 3 4
		// 0 1 2 3
		// 0 1
		// 0 1 2
		// 4-1 =3
		// 4-3=1
		// 4-2 =2

		int[] a = new int[] { 1, 2, 1, 3, 2, 3, 4 };
		int key = 4 ;
		int f=0;
		for (int i = 0; i < a.length; i = i + (key - a[i])) {
			if (key - a[i] == 0) {
				System.out.println("ans =" + i);
				f=1;
				break;
			}
		}
		if(f==0)
			System.out.println("No Ans");
	}
}
