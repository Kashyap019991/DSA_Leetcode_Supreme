package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for(char ch:tasks){
            taskFreq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0;i<taskFreq.length;i++){
            if(taskFreq[i] >0){
                pq.add(taskFreq[i]);
            }
        }

        int totTime =0;
        while(!pq.isEmpty()){
            List<Integer> currFreq = new ArrayList<Integer>();
            int cycle = n+1;
            int timeCount=0;
            while(cycle-- >0 && !pq.isEmpty()){
                int freq = pq.poll();
                if(freq >1)
                currFreq.add(freq-1);
                timeCount++;
            }
            for(int k:currFreq) pq.add(k);
            totTime += (pq.isEmpty() ? timeCount : n+1);
            
        }

        return totTime;
    }
    
    public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n =2;
		LeastInterval sl1 = new LeastInterval();
		System.out.println(sl1.leastInterval(tasks, n));
	}
}