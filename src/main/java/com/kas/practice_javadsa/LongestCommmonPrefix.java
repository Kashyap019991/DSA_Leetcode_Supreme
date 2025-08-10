package com.kas.practice_javadsa;
class LongestCommmonPrefix {
	
	    public String longestCommonPrefix(String[] strs) {
	        if(strs== null || strs.length == 0) return "";
	        
	        for(int i=0;i<strs[0].length();i++){
	            //if(strs[i].length() <=0 ) return "";
	            char c = strs[0].charAt(i);
	            for(int j=1;j<strs.length;j++)
	            {
	            if (
	                    i == strs[j].length() || strs[j].charAt(i) != c
	                ) return strs[0].substring(0, i);
	            }
	        }
	        return strs[0];
	    }
	
    //lc 20 lcp
    
    public static void main(String[] args) {
    	String[] strs = {""};
    	LongestCommmonPrefix sl = new LongestCommmonPrefix();
    	System.out.println(sl.longestCommonPrefix(strs));
	}
}