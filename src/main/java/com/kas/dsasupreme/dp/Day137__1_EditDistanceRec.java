package com.kas.dsasupreme.dp;

//Count Min no of op to convert string a to b
public class Day137__1_EditDistanceRec {
	 static int solveRec(String text1, String text2,int i, int j){
	     //base case
		 if(text1.length() == i) return text2.length() - j; //t1<t2
		 if(text2.length() == j) return text1.length() - i; // t1>te
		 
		 int ans =0;
		 if(text1.charAt(i) == text2.charAt(j))
			 ans = solveRec(text1,text2,i+1,j+1);
		 else
		 {
			int insop = 1 + solveRec(text1, text2, i, j+1);
			int replop = 1+ solveRec(text1, text2, i+1, j+1);
			int delop = 1 + solveRec(text1, text2, i+1, j);
			
			ans = Math.min(insop, Math.min(replop, delop));
		 }
		 return ans;
	    }
	public static void main(String[] args) {
		//Convert w1 -> w2
		String word1 = "horse", word2 = "ros"; //ans =3
		System.out.println(solveRec(word1, word2,0,0));
	}
}
