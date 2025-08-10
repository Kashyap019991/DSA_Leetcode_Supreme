package com.kas.dsasupreme.BinarySearch;

public class PeakIndexinMountainArr {

	static int peakIndexInMountainArr(int arr[]){
		
		int s =0;
		int e = arr.length -1;
		int mid = s + (e-s) /2;
		
		while(s < e)// <= then infinite loop bcoz when only 1 element loop ghumya kre
		{
			if(arr[mid] < arr[mid+1])//move right side
				s = mid+1;
			else
				e = mid;//move left side not skip mid
			
			mid =s + (e-s) /2;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,10,5,2};
		System.out.println(peakIndexInMountainArr(arr));
	}
}
