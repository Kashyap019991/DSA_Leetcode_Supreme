package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValidWordAbbr {
    Map<String,List<String>> mapDictionary = new HashMap();
    
    String findShortWord(String currString){
            int lenOfString = currString.length();
            
            if(lenOfString <=2)
                return currString;
            String count = String.valueOf(lenOfString-2);
            
            String shortWord = String.valueOf(currString.charAt(0)) + count +                               String.valueOf(currString.charAt(lenOfString-1));
        
        return shortWord;
    }
    
    public ValidWordAbbr(String[] dictionary) {
        
        for(String currString:dictionary){
           
           String shortWord = findShortWord(currString); 
            
            List<String> wordList = mapDictionary.getOrDefault(shortWord,new ArrayList());
            wordList.add(currString);
            
            mapDictionary.put(shortWord,wordList);
            
        }
    }
    
    public boolean isUnique(String word) {
        String shortWord = findShortWord(word);
        if(mapDictionary.get(shortWord) != null){
            List<String> listOfWord = mapDictionary.get(shortWord);
            
            for(String currWord:listOfWord){
                return (currWord.equals(word))?true:false;
                
                   
            }
            
        }
        return true;
    }
    
    
    public static void main(String[] args) {
		String[] dict = {"deer","door","cake","card"};
		
		ValidWordAbbr sl = new ValidWordAbbr(dict);
		sl.isUnique("dear");
		sl.isUnique("cart");
		sl.isUnique("cane");
		sl.isUnique("make");
		sl.isUnique("cake");
		
	}
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */