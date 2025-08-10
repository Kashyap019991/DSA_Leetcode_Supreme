package com.kas.dsasupreme.extra_classes;/*import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

*//** 
	* 
	* Hashset.java
	* 
	* Create a HashSet and add employee objects 
	* like name and id to it and print the HashSet. 
	* Also throw exception for bad inputs and generate a unique hash for all the employee ids before storing it.
	* *//*
		class Employee{
		int id;
		String Name;
		public int getId() {
		return id;
		}
		public void setId(int id) {
		this.id = id;
		}
		public String getName() {
		return Name;
		}
		public void setName(String name) {
		Name = name;
		}
		
		
		}
		public class HashSetEmpl{
		public static void main(String[] args) {
		Employee e = new Employee();
		e.setId(1);
		e.setName("abc");
		Employee e1 = new Employee();
		e1.setId(2);
		e1.setName("xyz");
		
		Set<Employee> hs =new HashSet<Employee>();
		hs.add(e);
		hs.add(e1);
		
		//hs.forEach(e -> {System.out.println(e)});
		hs.stream().forEach(s1 -> System.out.println(s1.getId()));
		//hs.stream().filter(s1 -> if(s1.getId() == 2));
		List<Employee> ls =new ArrayList<>();
		ls.addAll(hs);
		ls.stream().filter(l -> l.getId()==2).forEach(l1->System.out.println(l1.getName()));
		ls.stream().sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName)).forEach(l -> System.out.println(l.getId()));
		Map<Integer,Employee> hm = new HashMap<Integer,Employee>();
		hm.put(1,e);
		hm.put(2,e1);
		Map<Integer,Employee> hsm = hm.entrySet().stream()
					 .filter(x -> x.getValue().getId() >1)
					 .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		
		hsm.entrySet().forEach(x -> System.out.println(x.getKey() +" " +x.getValue().getName()));
		//System.out.println(hm.get(1));
		}
		
		}
		*/

import java.io.*;

class SubSequence {
	// Returns true if str1[] is a subsequence of str2[]
	// m is length of str1 and n is length of str2
	static boolean isSubSequence(String str1, String str2, int m, int n) {
		// Base Cases
		if (m == 0)
			return true;
		if (n == 0)
			return false;

		// If last characters of two strings are matching
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return isSubSequence(str1, str2, m - 1, n - 1);

		// If last characters are not matching
		return isSubSequence(str1, str2, m, n - 1);
	}

	// Driver program
	public static void main(String[] args) {
		String str1 = "gksrek";
		String str2 = "geeksforgeeks";
		int m = str1.length();
		int n = str2.length();
		boolean res = isSubSequence(str1, str2, m, n);
		if (res)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}