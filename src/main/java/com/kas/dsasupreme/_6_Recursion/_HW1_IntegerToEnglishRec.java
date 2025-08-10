package com.kas.dsasupreme._6_Recursion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class _HW1_IntegerToEnglishRec {
	
	static Map<Integer,String> intToWord = new LinkedHashMap<Integer,String>(){{
		put(1000000000,"Billion");
		put(1000000,"Million");
		put(1000,"Thousand");
	    put(100,"Hundred");
	    put(90,"Ninety");
	    put(80,"Eighty");
		put(70,"Seventy");
		put(60,"Sixty");
		put(50,"Fifty");
		put(40,"Forty");
		put(30,"Thirty");
		put(20,"Twenty");
		put(19,"Nineteen");
	    put(18,"Eighteen");
		put(17,"Seventeen");
	    put(16,"Sixteen");
		put(15,"Fifteen");
	    put(14,"Fourteen");
		put(13,"Thirteen");
	    put(12,"Twelve");
		put(11,"Eleven");
		put(10,"Ten");
	    put(9,"Nine");
		put(8,"Eight");
	    put(7,"Seven");
		put(6,"Six");
		put(5,"Five");
		put(4,"Four");
	    put(3,"Three");
		put(2,"Two");
	    put(1,"One");
		
	}};
	public static String numberToWords(int num) {
		if(num == 0) return "Zero";
		for (Entry<Integer,String> it: intToWord.entrySet()) {
			if(it.getKey() <= num){
				String a = "";
				if(num >= 100){
						a =numberToWords(num/it.getKey())  + " " ;
				}
				String b = it.getValue();
				
				String c = "";
				if(num % it.getKey() !=0){
					c = " " + numberToWords(num %it.getKey());
				}
				return a + b +c;
			}
			
		}
		return "";
	}

	public static void main(String[] args) {

		System.out.println(numberToWords(14));
	}
}
// 0 1 1 2 3 5 8
// 1 2 3 4 5