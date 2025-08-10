package com.kas.practice_javadsa;

import java.util.HashSet;
import java.util.Set;

public class SmalestElem {

	static int smallest(int A[],int[] B,int n) {
		int sm=-1;
		/*
		 * int sm=-1; for(int i=0;i<n;i++) { for(int j=0;j<n;j++) { if(A[i] == B[j])
		 * break; if(j==n) sm =A[i]; }
		 * 
		 * 
		 * }
		 */

		Set<Integer> st = new HashSet<Integer>();
		for(int i=0;i<n;i++)
		{
			st.add(B[i]);
		}
		
		for(int i=0;i<n;i++) {
			if(!st.contains(A[i])) {
				sm=A[i];
			}
		}
		return sm;
		}

		

	
	public static void main(String[] args) {
//smallest element from A which is not match
int[] A= {1,2,3,5,6,6};

int[] B = {1,2,3,5,5,5};
//{1,2,3,5,6,6};  {2,3,3,4,4,5};

//{1,2,3,5,6,6};    {1,2,3,3,4,5};
System.out.println(smallest(A,B,A.length));
}
}