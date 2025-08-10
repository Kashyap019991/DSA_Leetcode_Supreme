package com.kas.dsasupreme.extra_classes;

import java.util.*;
class FindCeleb {
	    public static int alienOrder(int n) {
			int cel = 0;
	    	for(int i=1;i<n;i++) {
	    		if(knows(cel,i) == 1)
	    			cel = i;
	    	}
	    	
	    	if(isCeleb(cel,n))
	    		return cel;
	    	
	    	
	    	return -1;
	    }
	    
	    static boolean isCeleb(int cel,int n) {
	    	
	    	for(int j =0;j<n;j++)
	    	{
	    		if(cel == j ) continue;
	    		
	    		if(knows(cel,j) == 1 || (knows(j,cel) ==0) )
	    			return false;
	    	}
	    	return true;
	    }
	    public static void main(String[] args) {
	    	
	    	System.out.println(alienOrder(3));
	    	
	    	
	    }

	    static int knows(int i, int j){
	    	int[][] det={
	    			{1,0,0},
	    			{1,1,0},
	    			{1,1,0}
	    			//{1,0,1},{1,1,0},{0,1,1}
	    			//{1,0},{0,1}
	    			//{1,1},{1,1}
	    	};
	    			 /*{1,1,0},
		    		 {0,1,0},
		       		 {1,1,1}};*/
			return det[i][j];
		
	    }
    
}