package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

public class _HW2_ReveOnlyLetters_LC2917 {
	
	    static void swap(String s,int i,int j){
	        //StringBuilder sb1 = new StringBuilder(s);
	        sb.setCharAt(i,s.charAt(j));
	        sb.setCharAt(j,s.charAt(i));
	        //return sb;
	    }
	    static StringBuilder sb = new StringBuilder(); //to save memory
	    public static  String reverseOnlyLetters(String s) {
	        int l=0; 
	        int h = s.length()-1;
	        sb =new StringBuilder(s);
	        //static StringBuilder sb = new StringBuilder(s);
	        while(l < h){
	            //check whether curr char at l and h is alphabet
	            if(Character.isLetter(sb.charAt(l)) && Character.isLetter(sb.charAt(h))){
	                swap(s,l,h);
	                //System.out.println(sb);
	                h--;
	                l++;
	            }
	            else if(!Character.isLetter(sb.charAt(l))) l++;
	            else h--;
	        }
	        return sb.toString();
	    }
	
	    public static void main(String[] args) {
			System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
		}
	
}
