package com.kas.dsasupreme.BinarySearch;

import java.util.Scanner;

public class LH_LeftRotateByOne {

	static int[] reverse(int[] ip,int start, int end){
		
		while(start <= end){
			int temp = ip[start];
			ip[start] = ip[end];
			ip[end] = temp;
			start++;
			end--;
		}
		return ip;
		
	}
	public static void main(String[] args) {
		
		int[] ip = new int[5];
		//int[] op = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter k as position to shift left");
		int k = sc.nextInt();
		System.out.println("Enter 5 element");
		for (int i = 0; i < ip.length; i++) {
			ip[i] =sc.nextInt();
		}
		
		
		//1. reverse first k element
		ip = reverse(ip,0,k-1);
		//2.reverse n-k element
		ip = reverse(ip,k,5-1);
		//3. reverse full array
		ip = reverse(ip,0,5-1);
		System.out.println("shifting done by k pos left");
		for(int i=0;i<ip.length;i++)
		{
			System.out.println(ip[i]);
		}

	}
}
/*
 * k=2
 * 1 3 5 7 9
 * 5 7 9 1 3
 * logic: left n-k = 5-2=3 , 2 --> smaller 2 then 1st rev 2, 2nd remaining 3 reverse, then full array reverse
 * for right shift  : n-k = 5-2 = 3 ,2 --> bigger is 3 then 1st rev 3 , then remaining 2 revese , then full array reverse
 * 1. reverse last k element
 * 2. reverse first n-k emenent
 * 3.reverse full array
 */
