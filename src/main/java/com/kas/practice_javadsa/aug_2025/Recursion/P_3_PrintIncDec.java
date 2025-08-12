package com.kas.practice_javadsa.aug_2025.Recursion;

//print no in inc and decresasin order
//n=3 then print 1 2 3 and 3 2 1
class P_3_PrintIncDec{
	public void printInc(int n){
	if(n==0)
		return;
		
	printInc(n-1);
	System.out.print(n+" ");


	}

	public void printDec(int n){
	if(n==0)
		return;
		

	System.out.print(n+" ");
	printDec(n-1);

	}

	public static void main(String[] args) {
		int n=3;
		new P_3_PrintIncDec().printDec(n);
		System.out.println();
		new P_3_PrintIncDec().printInc(n);
	}
}