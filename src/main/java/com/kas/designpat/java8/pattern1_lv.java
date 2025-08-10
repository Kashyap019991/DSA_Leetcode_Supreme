package com.kas.designpat.java8;

public class pattern1_lv {
	public static void main(String[] args) {
		/*int n=5,m=6;
		for(int row=0 ; row< n;row++){
			for(int col = 0;col<m;col++){
				if(row == 0  || row ==n-1)
					System.out.print("*  ");
				else{
					if(col == 0 || col == m-1)
						System.out.print("*  ");
					else 
						System.out.print("#  ");
				}
				}
			System.out.println();
		}*/
		
		//pat2
		/*int n=5;
		for(int row = 0;row <n;row++){
			for(int col = 0;col<=row;col++){
				System.out.print(col+1 + " ");
			}
			System.out.println();
		}*/
		
		//pat 3
		int n=4;
		for(int row = n;row>0;row--){
			for(int col = row;col > 0;col--){
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
}
