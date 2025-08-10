package com.kas.dsasupreme.BinarySearch;

import java.util.Scanner;

public class LeftRotateByKpos {

	public static void main(String[] args) {
		int[] ip = new int[5];
		int[] op = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < ip.length; i++) {
			ip[i] =sc.nextInt();
		}
		
		for(int i=ip.length -1,j=0;i>=0;i--,j++){
			if(i != 0){
			op[j] = ip[i];
			}
			else{
				op[ip.length-1] = ip[i];
			}
		}
		
		for(int i=0;i<op.length;i++)
		{
			System.out.println(op[i]);
		}

	}
}
