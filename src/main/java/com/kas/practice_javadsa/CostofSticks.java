package com.kas.practice_javadsa;

import java.util.PriorityQueue;

class CostOfSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //2,4,3 //
        
        for(int elem:sticks){
            minHeap.add(elem);
        }
        int costOfSticks = 0;
        while(minHeap.size() !=1){
            int firstElem = minHeap.poll();
            int secondElem = minHeap.poll();
            
            costOfSticks += firstElem+secondElem;
            minHeap.add(firstElem + secondElem);
            
            //2+3=4,5
        }
        
        return costOfSticks;
    }
    
    public static void main(String[] args) {
		int[] arr = {2,4,3};
		DecodeString sl2= new DecodeString();
		System.out.println(sl2.connectSticks(arr));
	}
}

//2+3 =5
//4+5 =9