package com.kas.dsasupreme.dp;

public class Day1_ReahHome {

	public static void reachHome(int src, int dest){
		
		if(src == 10)
		{
			System.out.println("reached home");
			return;
		}
		
		src++;
		
		reachHome(src,dest);
		
	}
	public static void main(String[] args) {
		
		int src=1;
		int dest =10;
		
		reachHome(src,dest);
	}
}
