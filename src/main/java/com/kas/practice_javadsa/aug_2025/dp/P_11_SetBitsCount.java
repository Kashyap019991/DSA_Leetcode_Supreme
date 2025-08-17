package com.kas.practice_javadsa.aug_2025.dp;

public class P_11_SetBitsCount {
    public static void main(String[] args) {

        //till 10 find set bit
        int n=10;
        int dp[] = new int[n+1];
        dp[0]=0;
        for(int i=0;i<=10;i++){
            dp[i] = dp[i/2]+(i%2);//left shift by 1(i*2), right shift by 1 (i/2) and last bit set 1 iff odd
            System.out.println(dp[i]);
        }
    }
}
