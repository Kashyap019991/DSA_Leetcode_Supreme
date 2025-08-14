package com.kas.practice_javadsa.aug_2025.Backtaracking;

import java.util.ArrayList;
import java.util.List;

class P_7_GenerateParenthesis {

    static  List<String> results = new ArrayList<>();
    //static String result = "";
    public List<String> generateParenthesis(int n) {
        genParenHelper("",n,0,0,0);
        return results;
    }

    private void genParenHelper(String result , int n, int index, int open, int close) {
        if(index == 2*n){

            results.add(result);
            //result = "";

            return;
        }

        if(open < n){
            result = result + "(";
            genParenHelper(result, n,index+1,open+1,close);

            result = result.substring(0,result.length()-1);//back track

        }
        if(close < open){
            result = result + ")";
            genParenHelper(result,n,index+1,open,close+1);
            result = result.substring(0,result.length()-1);
        }

    }

    public static void main(String[] args) {
        int n=3;
        new P_7_GenerateParenthesis().generateParenthesis(n);
        System.out.println("kashyap:"+results);
    }
}