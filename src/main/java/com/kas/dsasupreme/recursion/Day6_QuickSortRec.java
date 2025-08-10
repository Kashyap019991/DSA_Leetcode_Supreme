package com.kas.dsasupreme.recursion;

class Day6_QuickSortRec {
	static int[] a = { 44, 23, 11, 25 };

	static void swap(int s, int p){
		int temp = 0;
		temp = a[p];
		a[p] = a[s];
		a[s] = temp;
	}//4 3 2 5 6 
	static int partition(int s,int e){
		int count = 0;
		for(int i=s+1;i<=e;i++){
			if(a[i] < a[s])  count++;
		}
		
		//pivotIndex at right place
		int pivotIndex = s+ count;
		swap(s,pivotIndex);
		
		//5 2 3 1 4
	//    i       j
		
		
		int i = s;
		int j = e;
		//swap <pivot to left part and > pivot to right part
		while(i < pivotIndex &&  j > pivotIndex){
			
			while(a[i] <= a[pivotIndex]) i++;
			while(a[j] >= a[pivotIndex]) j--;
			
			swap(i,j);
			i++;j--;
		}
		
		return pivotIndex;
	}
	static void quickSrt(int s, int e){
		
		if(s >= e) return;
		
		int p = partition(s,e);
		
		//left wala part
		quickSrt(s,p-1);
		//right wala part
		quickSrt(p+1,e);
		
	}
	public static void main(String[] args) {

		quickSrt(0, a.length - 1);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}