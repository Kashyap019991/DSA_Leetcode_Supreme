package com.kas.dsasupreme.extra_classes;

class BitFlip
{
    // Find the total number of bits needed to be flipped to convert `x` to `y`
    public static int findBits(int x, int y)
    {
       int n =x ^ y;
       
       int count =0;
       
       while(n !=0){
    	   
    	   if((n & 1) == 1 ) count++;
    	   n >>= 1;
       }
        return count;
    }
 
    public static void main(String[] args)
    {
        int x = 10;
        int y = 20;
 
        System.out.println(x + " in binary is " + Integer.toBinaryString(x));
        System.out.println(y + " in binary is " + Integer.toBinaryString(y));
 
        System.out.println("\nThe total number of bits to be flipped is " + findBits(x, y));
    }
}