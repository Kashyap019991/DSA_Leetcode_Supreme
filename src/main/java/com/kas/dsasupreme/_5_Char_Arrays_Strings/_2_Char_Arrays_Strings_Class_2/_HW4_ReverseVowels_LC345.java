package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
//https://leetcode.com/problems/reverse-vowels-of-a-string/
class _HW4_ReverseVowels_LC345 {
    public String reverseVowels(String s) {
        int l =0;
        int h= s.length()-1;
        String str = "aeiouAEIOU";
        while(l < h){

            //check char is vowel for l and h
            if(str.indexOf(s.charAt(l)) != -1 && str.indexOf(s.charAt(h)) != -1)
            {
                //System.out.println(l + " "+h);
                char lch =  s.charAt(l);
                s = s.substring(0,l) + s.charAt(h) + s.substring(l+1);
                s = s.substring(0,h) +lch+ s.substring(h+1);
                l++;
                h--;
            }
            else if(str.indexOf(s.charAt(l)) == -1)
                l++;
            else h--;
        }
        return s;
    }
}