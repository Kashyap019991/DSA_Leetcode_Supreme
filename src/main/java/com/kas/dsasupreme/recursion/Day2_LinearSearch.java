package com.kas.dsasupreme.recursion;

public class Day2_LinearSearch {
	static int arr[] = { 1, 2, 3, 4, 5 };
	static int k =2;
    // Return sum of elements in A[0..N-1]
    // using recursion.
    static Boolean linearSearch(int A[], int N)
    {
    	if(N<0){
    		return false;
    	}
    	if(k==A[N]) return true;
    	else {
    		System.out.println(N);
    	return linearSearch(A,N-1);
    	}
		
		
        
    }
 
    // Driver method
    public static void main(String[] args)
    {
        System.out.println(linearSearch(arr, arr.length-1));
    }
}
//412
//41
//4
//0
	 // 1 2 3 4 5