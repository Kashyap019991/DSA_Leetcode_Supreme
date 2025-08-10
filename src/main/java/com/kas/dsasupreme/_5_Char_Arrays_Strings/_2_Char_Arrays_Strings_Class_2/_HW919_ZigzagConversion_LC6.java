package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

class _HW919_ZigzagConversion_LC6 {
	public static String convert(String s, int numRows) {


		String[] sarr = new String[numRows];
		Arrays.fill(sarr, "");
		int counter =0;//PAYPALISHIRING
		Boolean dir = false;//t -> b
		for(int i=0;i<s.length();i++){
			sarr[counter] = sarr[counter] + s.charAt(i);	//s[0] = P  ,s[1]=A, s[2] =Y ,s[3] = P 
				if(dir == false){ //means top to bottom then incresing
					counter++; //1,2,3,4
				}
				else{
					counter--;
				}
			if(counter == numRows ) //i.e numrows=4 then 4
				{
				counter = counter-2; // 2
				dir = !dir;//true
				}
			else if(counter < 0) //-1
			{
				counter = counter+2; // 2
				dir = !dir;//true
			}		
		}
		String ans = "";
		for(int i =0 ; i<sarr.length;i++){
			ans += sarr[i];
		}
		return ans;
	 }
	public static void main(String[] args) {
		
		System.out.println(convert("AB",1));
	}
}
/*s =
"PAYPALISHIRING"
numRows =
4*/
//PINALSIGYAHRPI
//PINALSIGYAHRPI
//PAHNAPLSIIGYIR
//PAHNAPLSIIGYIR