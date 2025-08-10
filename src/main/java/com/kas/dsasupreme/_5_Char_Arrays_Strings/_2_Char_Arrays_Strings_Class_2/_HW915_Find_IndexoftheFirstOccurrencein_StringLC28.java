package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
class _HW915_Find_IndexoftheFirstOccurrencein_StringLC28 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(); //8
        int m = needle.length();//3
        //0 1 2 3 4 5 6 7
        //s a b u r s a d
        //sad
                    //8-3+1
        for(int i =0;i<n-m+1;i++)
        {
            for(int j =0;j<m;j++){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    break;
                }
                //successfully matched all char of needle
                if(j == m-1)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}