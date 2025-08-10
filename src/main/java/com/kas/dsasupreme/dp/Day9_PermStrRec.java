package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Day9_PermStrRec {
	static String ipd = "abc";
	
	static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	    
	    static int[] swap(int i, int j,int[] nums){
	        int tmp= nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	        return nums;
	        
	    }
	    static void permArray(int indx,ArrayList<Integer> op){
	        
	        if(indx >= op.size()){
	            
	            ans.add(new ArrayList<>(op));
	            return;
	        }
	        
	        for(int i=indx; i<op.size();i++){
	        	Collections.swap(op,indx,i);
	            permArray(indx+1,op);
	            Collections.swap(op,indx,i);
	        	
	        }
	    }
	    public static List<List<Integer>> permute(int[] nums) {
	        ArrayList<Integer> op = new ArrayList<>();
	        
	        int indx = 0;
	        
        	for (int i1 : nums) {
                op.add(i1);
            }
	        permArray(indx,op);
	        return ans;
	    }
	
	public static void main(String[] args) {
		
		String output = new String();
		int[] nums ={1,2,3};
		permute(nums);
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	///issue of overriding prvious element
	/*public static void main(String[] args) {
	    
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    ArrayList<ArrayList<Integer>> d = new ArrayList<ArrayList<Integer>>();
	    
	    
	    a.add(34);
	    a.add(35);
	    a.add(36);
	    d.add(a);
	    System.out.println(a);
	    System.out.println(d);
	    a.clear();
	    a.add(4);
	    a.add(5);
	    a.add(6);
	    d.add(a);
	    System.out.println(a);
	    System.out.println(d);

	}
*/
}