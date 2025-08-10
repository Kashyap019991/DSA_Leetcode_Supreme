package com.kas.practice_javadsa;

class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) 
        	S.append(A);
        if (S.indexOf(B) >= 0) 
        	return q;
        if (S.append(A).indexOf(B) >= 0) 
        	return q+1;
        return -1;
    }
	
	//686. Repeated String Match
	public static void main(String[] args) {
		String a = "abcd", b = "cdabcdab";
		RepeatedStringMatch sl = new RepeatedStringMatch();
		System.out.println(sl.repeatedStringMatch(a,b));
	}
}