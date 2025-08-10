package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class WordLadder2 {
		List<List<String>> ans = new ArrayList<>();
		Map<String,List<String>> adjList = new HashMap<String,List<String>>();
		void bfs(List<String> wordList,String beginWord){
			Queue<String> q = new LinkedList<>();
			q.add(beginWord);
			
			while(!q.isEmpty()) {
				
				
			}
			
			
		//return adjList;
		
	}
	
	List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList) {
		return ans;
			
	}
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
		String beginWord = "hit";
		String endWord = "cog";
		WordLadder2 wl2 = new WordLadder2();
		System.out.println(wl2.findLadders(beginWord,endWord,wordList));
	}
}
