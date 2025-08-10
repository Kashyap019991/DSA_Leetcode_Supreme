package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
class _HW8_SubsequenceOfArray {
    
      public static  void substring(int[] arr) {
    	  int n = arr.length;	
    	  for(int i=0;i<n;i++)
    	  {
    		  for(int j=i;j<n;j++){
    			  for(int k = i;k<=j;k++)
    			  	{ 
    				  System.out.print(arr[k] + " ");
    				  }
    			     System.out.println();
    			  }
    		 // System.out.println();
    	  }
    	  
    }
       public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		substring(arr);
	}
}