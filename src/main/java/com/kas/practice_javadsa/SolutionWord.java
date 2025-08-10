package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionWord {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        Map<Character,Integer> freq1Map = new HashMap<Character,Integer>();
        Map<Character,Integer> freq2Map = new HashMap<Character,Integer>();
        for(char ch:word1.toCharArray()){
            freq1Map.put(ch, freq1Map.getOrDefault(ch,0)+1);
        }
        for(char ch:word2.toCharArray()){
            freq2Map.put(ch, freq2Map.getOrDefault(ch,0)+1);
        }

        if(!freq1Map.keySet().equals(freq2Map.keySet()))
            return false;

        List<Integer> charMap1 = new ArrayList<Integer>(freq1Map.values());
        List<Integer> charMap2 = new ArrayList<Integer>(freq2Map.values());

        Collections.sort(charMap1);
        Collections.sort(charMap2);

        return charMap1.equals(charMap2);


    }
    
    public static void main(String[] args) {
		String word1 = "cabbba", word2 = "abbccc";
		
		SolutionWord sl = new SolutionWord();
		System.out.println(sl.closeStrings(word1,word2));
	}
}