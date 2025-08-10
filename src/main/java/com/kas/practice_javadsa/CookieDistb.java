package com.kas.practice_javadsa;

import java.util.Arrays;

class CookieDistb {
    static int ans =  Integer.MAX_VALUE;
    private static void dpDistCookies(int index, int[] cookies,int k,int[] cookiesCount){
        
        if(index == cookies.length){

            int maxCookie = 0;
            for(int i=0;i<k;i++){
                maxCookie = Math.max(maxCookie, cookiesCount[i]);
            }
            ans = Math.min(ans,maxCookie);
            return;
        }

        for(int i=0;i<k;i++){
            cookiesCount[i] += cookies[index];
            dpDistCookies(index+1,cookies,k,cookiesCount);
            cookiesCount[i] -= cookies[index];
        }
        return;
    }
    public static void distributeCookies(int[] cookies, int k) {
       int[] cookiesCount = new int[k];

       dpDistCookies(0,cookies, k, cookiesCount); 
       System.out.println(Arrays.toString(cookiesCount));
    }
    
    public static void main(String[] args) {
		int[] cookie = {8,15,10,20,8};
		int k =2;
		distributeCookies(cookie, k);
		System.out.println(ans);
	}
}

//https://leetcode.com/problems/fair-distribution-of-cookies/solutions/5261414/lemon-recursion-oh-easy-it-is/