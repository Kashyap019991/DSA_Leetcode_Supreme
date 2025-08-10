package com.kas.dsasupreme._10_Graph.Class6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pairwl {
	ArrayList<String> ls;
	int i1;

	Pairwl(ArrayList<String> ls, int i1) {
		this.ls = ls;
		this.i1 = i1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i1;
		result = prime * result + ((ls == null) ? 0 : ls.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pairwl other = (Pairwl) obj;
		if (i1 != other.i1)
			return false;
		if (ls == null) {
			if (other.ls != null)
				return false;
		} else if (!ls.equals(other.ls))
			return false;
		return true;
	}
}

public class lc_126_Wordladder2_assignment {
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Queue<Pairwl> q = new LinkedList<Pairwl>();
		char[] arr = beginWord.toCharArray();
		int currLvl = 1;
		List<String> cpWordList = new ArrayList<>(wordList);
		List<List<String>> ans = new ArrayList<List<String>>() ;
		// 1st insert beginword wih lvl 1
		Set<String> st = new HashSet<>();
        wordList.forEach(element -> st.add(element));
        
		ArrayList<String> ls = new ArrayList<String>();
		ls.add(beginWord);
		q.add(new Pairwl(ls, 1));

		int prevLvl = -1;
		List<String> toBeRemoved = new ArrayList<>();
		while (!q.isEmpty()) {

			Pairwl fnode = q.poll();
			ArrayList<String> currLs = new ArrayList<>(fnode.ls);
			int currLvl1 = fnode.i1;
			String currStr = currLs.get(currLs.size() - 1);
			
			
	        
			if(currLvl1 != prevLvl){
				for(String s:toBeRemoved) 
					st.remove(s);
				toBeRemoved = new ArrayList<>();
				prevLvl = currLvl1;
			}
			
			//check khi dest tak to nhi pahoch gye
			if(currStr.equals(endWord)){
				ans.add(currLs);
			}
			/*for (int i = 0; i < beginWord.length(); i++) {
				char[] cp = currStr.toCharArray();
				for (int letter = 0; letter < 26; letter++) {
					//if (cp[i] != (char) ('a' + letter))
					{
						cp[i] = (char) ('a' + letter);
						//check in wordList
						for (String s : cpWordList) {
							if (String.valueOf(cp).equals(s)) {
								// ls.add(s);
								ArrayList<String> curt = new ArrayList<>(currLs);
								curt.add(s);
								q.add(new Pairwl(curt, currLvl1+1));
								toBeRemoved.add(s);
							}
						}
						
					}
				}
			}*/

            for(int i = 0; i< beginWord.length();i++){
                for(char ch ='a'; ch<='z';ch++){
                    char[] replacedWord = currStr.toCharArray();
                    replacedWord[i] = ch;
                    String replacedStr = new String(replacedWord);
                    if(st.contains(replacedStr)){
                        //st.remove(replacedStr);
                        ArrayList<String> curt = new ArrayList<>(currLs);
						curt.add(replacedStr);
						q.add(new Pairwl(curt, currLvl1+1));
						toBeRemoved.add(replacedStr);
                    }
                }
            }
			
		}
		return ans;

	}

	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
		List<List<String>> ans = findLadders(beginWord, endWord, wordList);
		
		System.out.println(ans.toString());
		

	}
}
