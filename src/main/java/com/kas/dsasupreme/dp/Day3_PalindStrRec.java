package com.kas.dsasupreme.dp;

public class Day3_PalindStrRec {
	static int arr[] = { 1, 2, 3, 4, 5 };
	 static int sum =0;
    // Return sum of elements in A[0..N-1]
    // using recursion.
	 static char[] charr;
	 static void swap(int i,int j){
		 char temp = 0;
		 temp = charr[i];
		 charr[i] = charr[j];
		 charr[j] = temp;
	 }
    static void revStr(String str)
    {
       charr= str.toCharArray();
       /*for(int i=0,j=charr.length-1;i<charr.length/2&&j>charr.length/2;i++,j--){
        	swap(i,j);
        }*/
        
        int i=0;int j=charr.length-1;
        ///OR while
        while(i<j){
        swap(i,j);
        i++;j--;
        
        }
        System.out.println(new String(charr));
    }
	 static Boolean revStrRec(int i , int j)
	    {
	       
	       //if(i >= charr.length/2 && j <= charr.length/2) return;
	      if(i >j) return true;
	       if(charr[i] != charr[j])
	       return false;
	       else 
	    	   {
	    	   return revStrRec(i+1,j-1);
	    	   }
		
	    	   }
	       
	        
	    
    // Driver method
    public static void main(String[] args)
    {	String str = "aaaa";
    	charr= str.toCharArray();
    	//revStr(str);
        
        System.out.println(revStrRec(0,charr.length-1));
    }
}
//412
//41
//4
//0
	 // 1 2 3 4 5