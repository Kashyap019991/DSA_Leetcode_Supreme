package com.kas.designpat.cisco;
//https://leetcode.com/discuss/interview-question/791556/find-alphabetically-maximum-substring-from-string
import java.util.*;

public class LexicoMaxSubStr {

    static String lexicoMaxSub(String str){ 
        // loop to find the max leicographic 
        // substring in the substring array 
        String mx = "";
        for(int i=0;i<str.length();i++){
        	//a cmp b -1 , b cmp a 1
        	if(mx.compareTo(str.substring(i)) < 0){
        		mx = str.substring(i);
        	}
        }
        return mx;
    } 
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
       
        scan.close();
       
        System.out.println( lexicoMaxSub(s) );
    }
}
//ip: baca op:ca
//ip:ababaa
