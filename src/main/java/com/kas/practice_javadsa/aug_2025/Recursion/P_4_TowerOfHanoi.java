package com.kas.practice_javadsa.aug_2025.Recursion;

//Tower of Hanoi
class P_4_TowerOfHanoi{

	public void arrangeTowOfHanoi(int n, String from,String helper, String to){
		if(n==0)
			return;
			
		arrangeTowOfHanoi(n-1,from,to,helper);
		System.out.println(n +", "+ from +" -> "+ to);
		arrangeTowOfHanoi(n-1,helper,from,to);
	}

	public static void main(String[] args) {
		new P_4_TowerOfHanoi().arrangeTowOfHanoi(3,"A","B","C");
	}
}