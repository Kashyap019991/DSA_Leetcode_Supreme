package com.kas.dsasupreme.recursion;

public class Day2_SumOfArr {
/*static int count = 0;
static int sum = 0;
	public static void sumOfNum(int[] Nums,int n){
		
		if(count > n) return;
		
		sum = sum + Nums[count];
		count++;
		sumOfNum(Nums, n);
		
	}
	public static void main(String[] args) {
		int[] ar = {2,2,3,7};
		int n =3;
		sumOfNum(ar,n);
		System.out.println(sum);
	}*/

	static int arr[] = { 1, 2, 3, 4, 5 };
	 static int sum =0;
    // Return sum of elements in A[0..N-1]
    // using recursion.
    static int findSum(int A[], int N)
    {
        if (N <= 0)
            return 0;
        sum = findSum(A, N - 1);
        return sum + A[N - 1];
    }
 
    // Driver method
    public static void main(String[] args)
    {
        System.out.println(findSum(arr, arr.length));
    }
}
//412
//41
//4
//0
	 // 1 2 3 4 5