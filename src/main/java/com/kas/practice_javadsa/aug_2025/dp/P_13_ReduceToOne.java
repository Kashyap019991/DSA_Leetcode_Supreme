package com.kas.practice_javadsa.aug_2025.dp;

import java.util.Arrays;
//min steps to reach one : reduce num to 1, by divede 3 or 2 or substaract 1
public class P_13_ReduceToOne {

    static int[] memo;

    public int reduceOne(int n){


        if(n==1)
                return 0;
        if(memo[n] !=-1)
            return memo[n];
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;

        if(n%3==0)
            a = 1 + reduceOne(n/3);
        if(n%2 ==0)
            b =1+reduceOne(n/2);
        c =1 + reduceOne(n-1);

        memo[n] =Math.min(a,Math.min(b,c));
        return memo[n];

    }

    public static void main(String[] args) {
        int n=10;
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        System.out.println(new P_13_ReduceToOne().reduceOne(n));
    }
}
