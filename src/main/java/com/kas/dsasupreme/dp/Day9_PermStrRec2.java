package com.kas.dsasupreme.dp;

import java.util.ArrayList;

class Day9_PermStrRec2 {
	static String ipstr = "abc";
	static ArrayList<String> al = new ArrayList<String>();
	/*
					i=	0
								abc
				i=   1	
					abc  		 bac  		cba
			i=2
				abc   acb	  bac  bca	 cba    cab
			i=3
		        abc	  acb     bac  bca   cba    cab    
*/	
	static String swap(int i,int j){
		char[] a = ipstr.toCharArray();
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		return String.valueOf(a);
	}
	static void permStr(int indx){
		
		if(indx >= ipstr.length()){
			al.add(ipstr);
		}
		
		for(int i = indx; i<ipstr.length();i++){
		ipstr = swap(indx,i);
		permStr(indx+1);
		ipstr = swap(indx,i);
		}
		
	}
	public static void main(String[] args) {
		
		permStr(0);
		
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i));
		}
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
