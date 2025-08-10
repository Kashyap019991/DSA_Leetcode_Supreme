//https://leetcode.com/problems/valid-palindrome-ii/description/
package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
class _3_Valid_Palindrome_II_LC680 {
    boolean checkPalindrome(String s, int left, int right){
        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
            
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int slen = s.length();
        int i=0;
        int j= slen-1;
        while(i<=j){

            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return checkPalindrome(s,i+1,j) || checkPalindrome(s,i,j-1);
            }
        }
        return true;

        
    }
}