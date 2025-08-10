package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class minCostTollDiscount {
    public static int minimumCost(int n, int[][] highways, int discounts) {
        // BFS -> Djikstra
        // Queue -> PriorityQueue
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        
        for (int[] hw: highways) {
            int u = hw[0], v = hw[1], toll = hw[2];
            graph.computeIfAbsent(u, e->new ArrayList<int[]>()).add(new int[]{v, toll});
            graph.computeIfAbsent(v, e->new ArrayList<int[]>()).add(new int[]{u, toll});
        }
        int MAX_VAL = Integer.MAX_VALUE;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        heap.add(new int[]{0, 0, discounts});
        int[][] distances = new int[discounts+1][n];
        for (int[] d: distances) Arrays.fill(d, MAX_VAL);
        for (int d = 0; d < discounts; d++) distances[d][0] = 0;
        
        while (!heap.isEmpty()) {
            int[] arr = heap.poll();
            int cost = arr[0], city = arr[1], dis = arr[2];
            
            for (int[] pair: graph.getOrDefault(city, new ArrayList<>())) {
                int nei = pair[0], toll = pair[1];
                
                // Don't use discount
                int fullcost = toll + cost;
                if (fullcost < distances[dis][nei]) {
                    distances[dis][nei] = fullcost;
                    heap.add(new int[]{fullcost, nei, dis});
                }
                
                int halfcost = cost + toll/2;
                if (dis > 0 && halfcost < distances[dis-1][nei]) {
                    distances[dis-1][nei] = halfcost;
                    heap.add(new int[]{halfcost, nei, dis-1});
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= discounts; d++) ans = Math.min(ans, distances[d][n-1]);
        return ans >= MAX_VAL ? -1 : ans;
    }
    public static void main(String[] args) {

    	int[][] h = new int[][] {{1,3,17},{1,2,7},{3,2,5},{0,1,6},{3,0,20}};
    	int n =4;
    	int discounts = 20;
    	
    	System.out.println(minimumCost(n,h,discounts));
	}
}