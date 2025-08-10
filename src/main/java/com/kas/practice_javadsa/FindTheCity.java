package com.kas.practice_javadsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class PairCity {
    int to;
    int weight;
    
    PairCity(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        // Creating adjacency list
        ArrayList<ArrayList<PairCity>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new PairCity(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new PairCity(edges[i][0], edges[i][2])); // Since it's an undirected graph
        }

        // Initialize matrix with max values
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Distance to itself is 0
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }

        // Perform Dijkstra's Algorithm for each city
        for (int i = 0; i < n; i++) {
            PriorityQueue<PairCity> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            pq.add(new PairCity(i, 0));
            matrix[i][i] = 0;

            while (!pq.isEmpty()) {
                PairCity current = pq.poll();
                int node = current.to;
                int weight = current.weight;

                for (PairCity neighbor : adj.get(node)) {
                    int newDistance = weight + neighbor.weight;
                    if (newDistance < matrix[i][neighbor.to]) {
                        matrix[i][neighbor.to] = newDistance;
                        pq.add(new PairCity(neighbor.to, newDistance));
                    }
                }
            }
        }

        // Find the city with the minimum reachable cities within the threshold
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // If multiple cities have the same count, choose the largest city index
            if (count <= minCount) {
                minCount = count;
                minCity = i;
            }
        }

        return minCity;
    }
}