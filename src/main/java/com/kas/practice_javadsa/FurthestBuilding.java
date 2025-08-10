package com.kas.practice_javadsa;

import java.util.PriorityQueue;
import java.util.Queue;

class FurthestBuilding {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for(int  i=0;i< heights.length-1;i++){
            int climbCount = heights[i+1] - heights[i];
            if(climbCount <=0)
                continue;//skip bcoz we dont need ladder or brics
            
            minHeap.add(climbCount);
            if(minHeap.size() <= ladders)//check if we have sufficient ladder or not
                continue;//if sufficient ladder then skip
            
            int minClimb = minHeap.poll();
            if(ladders - minClimb >0)//if not sufficient ladder then use bricks
                ladders = ladders - minClimb;//minimum element should be removed
            else
                return i+1;
            
        }//8,15 //5,3
        return -1;
    
    }
    
    public static void main(String[] args) {
		int[] heights = {4,12,2,7,3,18,20,3,19};
		int bricks = 10;
		int ladders = 2;
		DecodeString sl = new DecodeString();
		sl.furthestBuilding(heights,bricks,ladders);
	}
}