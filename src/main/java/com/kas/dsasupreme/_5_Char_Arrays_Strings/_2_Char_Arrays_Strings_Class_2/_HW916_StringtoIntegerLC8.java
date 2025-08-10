package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
class _HW916_StringtoIntegerLC8 {
    public static int strToInteger(String s) {
    	int ans = 0;
    	int sign = 1;
    	int  i = 0;
    	if(s.length() == 0) return 0;
    	//check for leading space
    	while(i < s.length() && s.charAt(i) == ' '){ //" " ->i < s.length() && 
    		i++;
    	}
    	//check for sign 
    	if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) //+1
    	{
    		sign = s.charAt(i) == '-' ? -1 : 1;
    		i++;
    	}
    	//check for digit
    	while(i < s.length() && Character.isDigit(s.charAt(i))){
    		//check for range
    		//if(ans <= Integer.MAX_VALUE && ans >= Integer.MIN_VALUE){
    			
    			
    		if(ans > Integer.MAX_VALUE/10
    				|| (ans == Integer.MAX_VALUE/10&& s.charAt(i) > '7')){ //"2147483648" Output -2147483648 Expected 2147483647
    				return  sign == -1 ?  Integer.MIN_VALUE: Integer.MAX_VALUE;		
    		}
    		ans = ans * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
    //i/p -91283472332
  //   912834723 > 214748364
  //ans > Integer.MAX_VALUE/10  return int_min
    		//-1089159116
   // -2147483648
    		
    		
    		i++;
    	}
     ans = sign * ans;
    	return ans;
   }
    
    public static void main(String[] args) {
		System.out.println(strToInteger("2147483648"));
	}
}