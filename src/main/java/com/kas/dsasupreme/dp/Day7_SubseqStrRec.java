package com.kas.dsasupreme.dp;

import java.util.ArrayList;

class Day7_SubseqStrRec {
	static int[] a = {1,2,3};
	static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	
	static void subSetRec(int i,ArrayList<Integer> output){
		
		if(i>=a.length){
			ArrayList<Integer> op1 = new ArrayList<>();
			op1.addAll(output);
			
			ans.add(op1);
			return;
		}
		
		//exclude
		subSetRec(i+1,output);
		
		//include
		output.add(a[i]);
		subSetRec(i+1,output);
		output.remove(output.size()-1);
	}
	public static void main(String[] args) {
		ArrayList<Integer> output = new ArrayList<>();
		subSetRec(0,output);
		
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