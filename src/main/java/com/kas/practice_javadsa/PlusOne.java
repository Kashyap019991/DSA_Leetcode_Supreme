package com.kas.practice_javadsa;
class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length+1];

        for(int i=digits.length-1 ; i>=0;i--){
            if(digits[i]+1 !=10){
                digits[i] +=1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newOne = new int[digits.length+1];
        newOne[0] = 1;
        return  newOne;
    }
    public static void main(String[] args) {
		PlusOne sl = new PlusOne();
		
		int[] digits = {1,2,3,9};
		System.out.println(sl.plusOne(digits));
	}
}