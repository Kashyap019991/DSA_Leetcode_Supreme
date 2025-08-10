package com.kas.practice_javadsa;

public class MinWindowSubSequence {
	 public static String minWindow(String s1, String s2) {
	        int start=0;
	        int end =0;
	        int i=0;
	        String ans="";
	        int minLen =Integer.MAX_VALUE;
	        while(end < s1.length()){

	            if(i< s2.length() && s2.charAt(i)==s1.charAt(end)){
	                if(s2.length() ==1) return s2;
	                if(i==0)
	                start=end;

	                if(i==s2.length()-1){
	                    //string match completed record length of s1
	                    start = find(s1,s2,end);
	                    //record string
	                    if(end-start+1 < minLen){
	                        minLen = end-start+1;
	                        ans = s1.substring(start,end+1);
	                    
	                    }
	                    i=-1; //start matching s2 again
	                    //start=end+1;
	                    end = start + 1;
	                }
	                i++;
	            }
	            end++;
	        }
	        return ans;
	    }
	    static int find(String s1,String s2, int end){
	        int match = s2.length();
	        int start = end;
	        while(match >0){
	            if(s1.charAt(start--) ==s2.charAt(match-1)) match--;
	        }
	        return start+1;
	    }
	    public static void main(String[] args) {
			String s1 = "ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoeglanevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl";
			String s2 = "ntimcimzah";
			System.out.println(minWindow(s1,s2));
		}
}
