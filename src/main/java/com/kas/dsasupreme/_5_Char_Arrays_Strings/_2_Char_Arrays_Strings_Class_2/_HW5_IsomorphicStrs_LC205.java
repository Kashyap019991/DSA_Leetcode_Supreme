package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
//https://leetcode.com/problems/isomorphic-strings/
import java.util.Arrays;

class _HW5_IsomorphicStrs_LC205 {
    public boolean isIsomorphic(String s, String t) {
        int[] hash = new int[256];
        int[] tHash = new int[256];
        Arrays.fill(hash,0);
        Arrays.fill(tHash,0);

        for(int i =0;i<s.length();i++){
                //foo bar a-b 1map chk       //badc baba b->a single mappped check
            if(hash[s.charAt(i)] !=0  || tHash[t.charAt(i)] !=0)//means already maaping done
            {
                //check prev mapping same as curr one
                if(hash[s.charAt(i)] != t.charAt(i) || tHash[t.charAt(i)] != s.charAt(i))
                    return false;
                
            }
            else
            {
                //put mapping 
                hash[s.charAt(i)] = t.charAt(i);
                tHash[t.charAt(i)] = s.charAt(i);
            }
        }
        return true;

    }
}