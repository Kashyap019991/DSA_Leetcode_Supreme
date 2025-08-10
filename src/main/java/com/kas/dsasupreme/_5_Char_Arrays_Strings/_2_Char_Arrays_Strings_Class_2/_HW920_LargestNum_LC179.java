package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class _HW920_LargestNum_LC179 {
	 public static String largestNumber(int[] nums) {
	      List<String> snum= new ArrayList<String>();
		 for(int i =0; i< nums.length;i++){
			snum.add(String.valueOf(nums[i]));
		 }
		 Collections.sort(snum, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String t1 = o1+o2;
				String t2 = o2 + o1;
				/*
				 * "a".compareTo("b"); // returns a negative number, here -1
"a".compareTo("a"); // returns  0
"b".compareTo("a"); // returns a positive number, here 1
"b".compareTo(null); // throws java.lang.NullPointerException
				 */
				//if(t1.compareTo(t2)  == 1) //
					return t2.compareTo(t1); 
							//3 > 30 = -1 //not so it will arrange like 30 3 bcoz rev order bigger will be at first
					//102 > 210  = -1 //no
					//210 > 102 = 1 //yes
			}
			 //9534303
		// 	"9534330"
			//{3,30,34,5,9}
		});
		 String ans = "";
		 for(int i=0;i< snum.size();i++){
			 ans += snum.get(i);
		 }
		 return ans = ans.charAt(0) == '0' ? "0" : ans;
	    }
	public static void main(String[] args) {
		String[] arr = {"a","b","c",null};
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
		arr[1] = "d";
		System.out.println(list);
		
		/*System.out.println(largestNumber(new int[]{3,30,34,5,9}));*/
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