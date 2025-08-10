package com.kas.dsasupreme.extra_classes;

import java.util.*;
class AlienDict {
    public static String alienOrder(String[] words) {

        
        Map<Character, List<Character>> indegreeMap = new HashMap<>();
        Map<Character, Integer> indegreeCount = new HashMap<>();
//[1,0][2,0]
        for (String word:words) {
            for(Character c:word.toCharArray()){
            //int u = prerequisites[i][0]; //1
            //int v = prerequisites[i][1]; //0
            ///to find indegree of each node each v , u -> v
            //now for 1-> 0 ,2->0, indegree of 0 ->1,2
                if (indegreeMap.get(c) == null) {
                    indegreeMap.put(c, new ArrayList<>());
                    indegreeCount.put(c,0);
                }
            }
        }

       for(int i=0;i<words.length-1;i++){
        String w1 = words[i];
        String w2 = words[i+1];

        if(w1.length() > w2.length()  && w1.startsWith(w2))
            return "";
        //check not mTCHING CHAR
        for(int j=0;j< Math.min(w1.length(),w2.length());j++){
            if(w1.charAt(j) != w2.charAt(j)){
                indegreeMap.get(w1.charAt(j)).add(w2.charAt(j));
                indegreeCount.put(w2.charAt(j),indegreeCount.get(w2.charAt(j))+1);
                break;
            }
        }
       }


        //put all nodes in QUeue which has indegree =0, means least dependent
        
        Queue<Character> q = new LinkedList<>();
        for (Character c:indegreeCount.keySet()) {
            if (indegreeCount.get(c).equals(0))
                q.add(c);
            }

        
       StringBuilder sb = new StringBuilder();//op
        while(!q.isEmpty()) {
            Character fnode = q.remove();
            sb.append(fnode);
//            topo[ind++] = fnode;
            if (indegreeMap.get(fnode) != null) {
                for (Character nbr : indegreeMap.get(fnode)) {
                    int count = indegreeCount.get(nbr) - 1;
                    indegreeCount.put(nbr, count);
                    if (count == 0) {
                        q.add(nbr);
                    }
                }
            }
        }

        if (sb.length() < indegreeMap.size()) {
            return "";
        } else
            return sb.toString(); 
    }
    
    public static void main(String[] args) {
    	String[] words = {"wrt","wrf","er","ett","rftt"};
    	System.out.println(alienOrder(words));
	}

}