package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

class _HW918_IntegerToRoman_LC12 {
	public static String intToRoman(int num) {  
        String[] keys = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        for(int i=0;i<values.length;i++){
        	while(num >= values[i]){//58>50 , 8>5 , 3 >1 , 2>1 ,1 >1 ,0>1 no
        		num = num - values[i]; // 58-50 = 8 , 8-5 = 3 , 3-1 = 2 ,2-1=1 ,1-1 =0 
        		res.append(keys[i]);//LVIII
        	}
        }
        
        
        return res.toString();
    }
	public static void main(String[] args) {
		
		System.out.println(intToRoman(58));
	}
}