package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrListUncommonElem {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		Set<String> ans = new HashSet<String>();

		
		list1.add("a");
		list1.add("b");
		list1.add("f");
		list2.add("a");
		list2.add("e");
		list2.add("l");
		list2.add("q");
		
		List<String> uncommon = new ArrayList<> ();
		
		for(String s:list1) {
			if(!list2.contains(s)) 
				uncommon.add(s);
		}
		
		for(String s:list2) {
			if(!list1.contains(s))
				uncommon.add(s);
		}
		//list3.addAll(ans);
		System.out.println(uncommon.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));
	}
}
