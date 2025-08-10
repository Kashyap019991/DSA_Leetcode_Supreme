package com.kas.dsasupreme.dp;

import java.util.ArrayList;

class Day7_SubsetRec {
	static String a = "abc";
	static ArrayList<String> ans = new ArrayList<>();
	
	static void subSeqRec(int i,String output){
		
		if(i>=a.length()){
			
			if(output.length()>0)
			ans.add(output);
			
			return;
		}
		
		//exclude
		subSeqRec(i+1,output);
		
		//include
		output = output+a.charAt(i);
		subSeqRec(i+1,output);
		
	}
	public static void main(String[] args) {
		String output = new String();
		subSeqRec(0,output);
		
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