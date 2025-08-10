package com.kas.dsasupreme.dp;

//Count Min no of op to convert string a to b
public class Day137__4_EditDistanceTabSopt {
	static int solveTabSopt(String text1, String text2) {
		// base case
		// if(text1.length() == i) return text2.length() - j; //t1<t2
		// if(text2.length() == j) return text1.length() - i; // t1>te
		int[] curr = new int[text2.length() + 1];
		int[] next = new int[text2.length() + 1];
		
		for (int j = 0; j <= text2.length(); j++)
		{
			next[j] = text2.length() - j;
		}	

		for (int i = text1.length() - 1; i >= 0; i--) {
			for (int j = text2.length() - 1; j >= 0; j--) {
				//catch here - 2nd base case
				curr[text2.length()] = text1.length() - i;
				int ans = 0;
				if (text1.charAt(i) == text2.charAt(j))
					ans = next[j + 1];
				else {
					int insop = 1 + curr[j + 1];
					int replop = 1 + next[j + 1];
					int delop = 1 + next[j];

					ans = Math.min(insop, Math.min(replop, delop));
				}
				curr[j] = ans;
			}
			next = curr.clone();
		}
		return next[0];
	}

	public static void main(String[] args) {
		//multiple time b->s allowed
		
		String word1 = "b", word2 = ""; //ans =3
		//String word1 = "b", word2 = ""; //ans =3
		if(word1.length() == 0) System.out.println(word2.length());
		else if(word2.length() == 0) System.out.println(word1.length());
		else System.out.println(solveTabSopt(word1, word2));
	}
}
