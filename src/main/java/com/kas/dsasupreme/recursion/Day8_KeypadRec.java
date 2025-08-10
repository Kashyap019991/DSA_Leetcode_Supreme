package com.kas.dsasupreme.recursion;

import java.util.ArrayList;

class Day8_KeypadRec {
	static String ipd = "";
	static ArrayList<String> ans = new ArrayList<>();
	static String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static void keyPadRec(int i, String output){
		//base case check if ip 23 then when i- 0 1 2 at i=2 need to add it to ans i.e ad
		if(i>=ipd.length()){
			
			ans.add(output);
			
			return;
		}
		//get ith value from ip digit string , it will be char so convert it to int
		//bcoz we have to fing mapping i.e 23 ,i=0 then a=2 map[2] =abc
		int a= Character.getNumericValue(ipd.charAt(i));
		String s = mapping[a];
		
		//loop is to iterate each char of mapping string for abc --> a , b, c looping for 
		//3 times
		for(int j = 0; j<s.length();j++){
			
			output = output + s.charAt(j);
			keyPadRec(i+1,output);
			output = output.substring(0,output.length()-1);
		}
		
	}
	public static void main(String[] args) {
		
		String output = new String();
		if(ipd.length() != 0)
		keyPadRec(0,output);
		
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