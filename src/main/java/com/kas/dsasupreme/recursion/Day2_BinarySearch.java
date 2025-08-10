package com.kas.dsasupreme.recursion;

public class Day2_BinarySearch {
	static int arr[] = { 1, 2, 3, 4, 5 };
	static int k =7;
    // Return sum of elements in A[0..N-1]
    // using recursion.
    static Boolean binarySearch(int A[], int s, int e , int k)
    {
    	if(s>e){
    		return false;
    	}
    	int mid = s+(e-s)/2;
    	if(k==A[mid]) return true;
    	if(k<A[mid]) return binarySearch(A,s,mid-1,k);
    	else return binarySearch(A, mid+1, e, k);
		
		
        
    }
 
    // Driver method
    public static void main(String[] args)
    {
    	int s = 0;
    	int e = arr.length-1;
        System.out.println(binarySearch(arr, s , e,k));
    }
}
//412
//41
//4
//0
	 // 1 2 3 4 5