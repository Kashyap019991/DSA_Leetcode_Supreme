package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class FindChepestFlight {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
   
        k++;
        while (!q.isEmpty() && k > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] nodeInfo = q.poll();
                int node = nodeInfo[0];
                int currDist = nodeInfo[1];
                
                
                for (int[] adjNode : adj.get(node)) {
                    int nextNode = adjNode[0];
                    int nextDist = adjNode[1];
                    
                    
                    if (currDist + nextDist < dist[nextNode]) {
                        dist[nextNode] = currDist + nextDist;
                        q.offer(new int[]{nextNode, dist[nextNode]});
                    }
                }
            }
            k--;
        }
        
    
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    public static void main(String[] args) {
    	int n = 4,  src = 0, dst = 3, k = 1;
    	int[][] inp = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
    	FindChepestFlight sl = new FindChepestFlight();
    	sl.findCheapestPrice(n, inp, src, dst, k);
    	
	}
}