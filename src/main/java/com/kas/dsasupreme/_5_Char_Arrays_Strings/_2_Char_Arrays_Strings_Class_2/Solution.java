package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;


class Solution {
//    private static Map<Integer, String> conversionMap = new LinkedHashMap<Integer, String>(){{
//        put(1000,"M"); put(900, "CM"); put(500,"D"); put(400,"CD"); put(100, "C");
//        put(90, "XC");put(50,"L"); put(40,"XL");put(10,"X");put(9,"IX");
//        put(5, "V"); put(4,"IV");put(1,  "I");
//    }};

    //public static String intToRoman(int num) {
/*
    	if(num <= 0) return "";
        Map.Entry<Integer,String> entry = getConversion(num);
        return entry.getValue() + intToRoman(num - entry.getKey());
    }

    private static Map.Entry<Integer,String> getConversion(int val) {
        for (Map.Entry<Integer,String> i : conversionMap.entrySet()) {
            if(i.getKey() <= val) return i;
        }
        return new AbstractMap.SimpleEntry<>(0, "");
    }
    */
//    	String[] keys = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        String res = "";
//        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    	//find sum subarray from 2 array
	public static void main(String[] args) {
		

    	int arr[] = {10, 2, -2, -20, 10};//, s[] = {6, 2, 1, 5, 4};
    	int target = -10;
    	int n = arr.length;
    	int res =0;
    	  for (int i = 0; i < n; i++) {
              int sum = 0;
              for (int j = i; j < n; j++) {
                  // calculate required sum
            	//  System.out.print(arr[j] +" ");
                  sum += arr[j];
                  // check if sum is equal to required sum
                  if (sum == target)
                      res++;
              }
              //System.out.println();
          }
          System.out.println(res);
      }

    }