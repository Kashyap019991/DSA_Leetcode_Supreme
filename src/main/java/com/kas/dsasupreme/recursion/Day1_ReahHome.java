package com.kas.dsasupreme.recursion;

public class Day1_ReahHome {

	public static void reachHome(int src, int dest){
		
		System.out.println("Src: "+src+ "Dest: "+dest);
		//base case
		if(src == 10)
		{
			System.out.println("Ghar Pahoch Gya");
			return;
		}
		//processing
		src++;
		
		reachHome(src,dest);
		
	}
	public static void main(String[] args) {
		
		int src=1;
		int dest =10;
		
		reachHome(src,dest);
	}
}
