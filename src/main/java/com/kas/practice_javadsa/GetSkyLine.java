package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class GetSkyLine {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
       List<List<Integer>> ans = new ArrayList<>();

       List<List<Integer>> listOfEdges = new ArrayList();
       for(int i =0;i<buildings.length;i++){
            listOfEdges.add(Arrays.asList(buildings[i][0],i));//left edges,i
            listOfEdges.add(Arrays.asList(buildings[i][1],i));//right edges,i
       }
       //sort by x 
       Collections.sort(listOfEdges,(a,b)-> a.get(0)-b.get(0));
       //create prioQ for storing live building height wisr
       PriorityQueue<List<Integer>> live = new PriorityQueue<>((a,b)->b.get(0)-a.get(0));////height,right
       int idAtX =0;
       while(idAtX < listOfEdges.size()){
            int currX = listOfEdges.get(idAtX).get(0);

           

//while(idAtX < listOfEdges.size() && listOfEdges.get(idAtX).get(0) == currX){
            int b= listOfEdges.get(idAtX).get(1);
            if(buildings[b][0]==currX)//left side matching
            {
                //put right and height to PrioQueue
                live.offer(Arrays.asList(buildings[b][2],buildings[b][1]));//height,right
            }
            idAtX +=1;
//}
            //if currx building passeed then remove from live
            while(!live.isEmpty() && live.peek().get(1) <= currX)
                live.poll();
            
            //currMAxHght find
            int currMaxHeight = live.isEmpty() ? 0 :live.peek().get(0);

            //if currMaxHeight se bda building thin insert in ans
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1) != currMaxHeight)
         	   ans.add(Arrays.asList(currX,currMaxHeight));
       }
       return ans;
    }
    public static void main(String[] args) {
		int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		System.out.println(getSkyline(buildings));
	}
}