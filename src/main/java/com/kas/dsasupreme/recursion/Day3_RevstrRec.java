package com.kas.dsasupreme.recursion;

public class Day3_RevstrRec {
	
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
	 static void revStrRec(int i , int j)
	    {
	       
	       //if(i >= charr.length/2 && j <= charr.length/2) return;
	       if(i >j) return;
	       else 	swap(i,j);
	        revStrRec(i+1,j-1);
	        
	    }
    // Driver method
    public static void main(String[] args)
    {	String str = "abba";
    	String str1 = "abbs";
    	charr= str.toCharArray();
    	//revStr(str);
        revStrRec(0,charr.length-1);
        if(str1.equals(new String(charr)))
        System.out.println("palindrone");
        else System.out.println("Not palindrone"); 
    }
}
//412
//41
//4
//0
	 // 1 2 3 4 5