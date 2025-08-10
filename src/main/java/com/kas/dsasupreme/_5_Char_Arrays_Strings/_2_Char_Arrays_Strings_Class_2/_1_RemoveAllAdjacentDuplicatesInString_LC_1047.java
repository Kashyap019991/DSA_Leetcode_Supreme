//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
class _1_RemoveAllAdjacentDuplicatesInString_LC_1047 {
    public static String removeDuplicates(String s) {
       StringBuilder ans = new StringBuilder("");
       if(s.length() >=1 && s.length() <= 100000){
       for(int i=0;i<s.length();i++){
           //System.out.println("for i : "+ i);
           if(ans.length() > 0 && s.charAt(i) == ans.charAt(ans.length()-1)){
               ans.deleteCharAt(ans.length()-1);
               //System.out.println("deleting at i"+ans);
           }
           else{
               //ans.append(s.charAt(i));
               ans.insert(ans.length(),s.charAt(i));
               //System.out.println("inserting at i"+ans);
           }
       }
       }
        return ans.toString();

    }
    public static void main(String[] args) {
		String s = "abbaca"; //op ca
		System.out.println(removeDuplicates(s));
	}
}