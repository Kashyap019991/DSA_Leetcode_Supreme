package com.kas.designpat.extra;

//long text, first non repetative char
public class pattern {
	public static void main(String args[]) throws Exception {
		for(int row = 0; row<6;row++){
				for(int space = 0;space <6-row-1;space++){
					System.out.print("  ");
				}
				for(int star = 0;star <= row;star++){
					System.out.print("*  ");
				}
				System.out.println();
		}
	}
}