package com.kas.practice_javadsa.aug_2025.Recursion;

public class P_2_Fibonacci {
    public int getFibo(int n){
        if(n==0 || n==1)
            return n;

        int f1 = getFibo(n-1);
        int f2= getFibo(n-2);

        return f1+f2;
    }

    public static void main(String[] args) {
        int n =3;//0 1 1 2
        System.out.println(new P_2_Fibonacci().getFibo(n));
    }
}
