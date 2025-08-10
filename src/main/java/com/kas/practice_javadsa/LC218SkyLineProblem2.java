package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class LC218SkyLineProblem2 {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
       List<List<Integer>> answer = new ArrayList<>();
       List<List<Integer>> list = new ArrayList<>();
       for(int i=0;i<buildings.length;i++) {
    	   //insert left and right to list
    	   list.add((Arrays.asList(buildings[i][0],i)));
    	   list.add(Arrays.asList(buildings[i][1],i));
       }
       
       //sort by edges
       Collections.sort(list,(a,b) -> a.get(0)-b.get(0));
       
       //tallest live building first based(height,right)
       Queue<List<Integer>> live = new PriorityQueue<>((a,b) -> b.get(0) -a.get(0));
       
       int idAtx=0;
       
       while(idAtx<list.size()) {
    	   //we might have multiple point at same x
    	   int currx= list.get(idAtx).get(0);
    	   
    	   int b = list.get(idAtx).get(1);
    	   if(buildings[b][0] == currx) {
    		   int height = buildings[b][2];
    		   int right = buildings[b][1];
    		   live.offer(Arrays.asList(height,right));
    	   }
    	   idAtx +=1;
    	   
       
       //if the tallest building passd, remove it
       while(!live.isEmpty() && live.peek().get(1) <= currx)
    	   live.poll();
       
       //get The maxim height
       int currHeight = live.isEmpty() ? 0 :live.peek().get(0);
       
       //if the height changes at this currX
       //we add this skyline point to answer [currx,maxHeight]
       
       if(answer.isEmpty() || answer.get(answer.size()-1).get(1) != currHeight)
    	   answer.add(Arrays.asList(currx,currHeight));
       
       
       } 
      return answer;
    }
    
    public static void main(String[] args) {
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		System.out.println(getSkyline(buildings));
	}
}