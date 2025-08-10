package com.kas.dsasupreme._10_Graph.Class6;

//2937. Make Three Strings Equal
//https://leetcode.com/problems/make-three-strings-equal/description/
class LC2937_Make3StringEqual {
    public static int findMinimumOperations(String s1, String s2, String s3) {
        int len = Math.min(Math.min(s1.length(),s2.length()),s3.length());
        int index = 0;
        for(int i=0; i<len; i++){
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)){
                index++;
            }else{
                break;
            }
    }
        int ans = -1;
        if(index > 0)
            ans = (s1.length()-index) + (s2.length()-index) + (s3.length()-index);
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "abb", s3 = "ab";
        System.out.println(findMinimumOperations(s1,s2,s3));
    }
}