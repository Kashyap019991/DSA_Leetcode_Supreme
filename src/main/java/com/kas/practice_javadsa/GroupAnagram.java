package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> sortedMap =  new HashMap<>();
        List<List<String>> groupAnagram = new ArrayList<>();
        
        for(int i=0;i<strs.length;i++){
        	char[] ch = strs[i].toCharArray();
        	Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            
            if(sortedMap.get(sortedStr) == null)
                sortedMap.put(sortedStr,new ArrayList());
            
            List ls = sortedMap.get(sortedStr);
            ls.add(strs[i]);
            sortedMap.put(sortedStr,ls);
            
            
        }
        
        for(String key:sortedMap.keySet()){
            groupAnagram.add(sortedMap.get(key));
        }
        
        return groupAnagram;
    }
    
    public static void main(String[] args) {
		
	}
}