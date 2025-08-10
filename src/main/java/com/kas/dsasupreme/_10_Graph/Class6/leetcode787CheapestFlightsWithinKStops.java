package com.kas.dsasupreme._10_Graph.Class6;
import java.util.*;
class Pair1{
    int first;
    int second;
    public Pair1(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple1 {
    int first, second, third; 
    Tuple1(int first, int second, int third) {
        this.first = first; 
        this.second = second;
        this.third = third; 
    }
}
class leetcode787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pair1>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair1(flights[i][1], flights[i][2])); 
        }
        
        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating 
        // the no. of nodes between src and current node.
        Queue<Tuple1> q = new LinkedList<>(); 
        
        q.add(new Tuple1(0, src, 0));

        // Distance array to store the updated distances from the source. 
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        dist[src] = 0; 

        // Iterate through the graph using a queue like in Dijkstra with 
        // popping out the element with min stops first.
        while(!q.isEmpty()) {
            Tuple1 it = q.peek(); 
            q.remove(); 
            int stops = it.first; 
            int node = it.second; 
            int cost = it.third; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue; 
            for(Pair1 iter: adj.get(node)) {
                int adjNode = iter.first; 
                int edW = iter.second; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW; 
                    q.add(new Tuple1(stops + 1, adjNode, cost + edW)); 
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 
    }
    
}