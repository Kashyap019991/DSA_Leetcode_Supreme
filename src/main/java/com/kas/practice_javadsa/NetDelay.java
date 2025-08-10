package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class NetDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adjacency = new HashMap<Integer,List<int[]>>();

        for(int[] entity:times){
            int src =entity[0];
            int dst = entity[1];
            int t= entity[2];
            adjacency.computeIfAbsent(src, key -> new ArrayList<>()).add(new int[]{dst,t});
        }
        PriorityQueue<int[]> prQ = new PriorityQueue<int[]>(Comparator.comparingInt(a ->a[1]));
        prQ.add(new int[]{k,0});
        //int visited[] = new int[times.length];
        Set<Integer> visited = new HashSet<>();
        int delays =0;
        while(!prQ.isEmpty()){

            int[] curr =  prQ.poll();
            int des = curr[0];
            int time = curr[1];
           
        if(!visited.add(des)) continue;
        delays =Math.max(time,delays);

        List<int[]> neighbors = adjacency.getOrDefault(des,new ArrayList<>());

        for(int[] nbr:neighbors){
            int src = nbr[0];
            int nbrtime = nbr[1];

           
           
        }
    }

    return visited.size() == n?delays:-1;
}

public static void main(String[] args) {
	int[][] inp ={{2,1,1},{2,3,1},{3,4,1}};
			
	int n=4,k=2;
	
	
}
}