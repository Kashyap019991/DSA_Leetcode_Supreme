package com.kas.practice_javadsa.aug_2025.Backtaracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_9_HamiltonianPath {

    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list representation of the graph
    private boolean[] visited; // To keep track of visited vertices in the current path

    public P_9_HamiltonianPath(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V];
    }

    // Add an edge to the graph
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    // Main function to check for Hamiltonian Path
    public boolean hasHamiltonianPath() {
        // Try starting the path from each vertex
        for (int i = 0; i < V; i++) {
            if (findHamiltonianPath(i, 1)) { // Start from vertex i, path length 1
                return true;
            }
        }
        return false;
    }

    // Recursive helper function for backtracking
    private boolean findHamiltonianPath(int currentVertex, int pathLength) {
        visited[currentVertex] = true;

        if (pathLength == V) { // If all vertices are visited
            return true;
        }

        // Explore neighbors
        for (int neighbor : adj.get(currentVertex)) {
            if (!visited[neighbor]) {
                if (findHamiltonianPath(neighbor, pathLength + 1)) {
                    return true;
                }
            }
        }

        // Backtrack: remove currentVertex from path and mark unvisited
        visited[currentVertex] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Number of vertices
        int M = sc.nextInt(); // Number of edges

        P_9_HamiltonianPath graph = new P_9_HamiltonianPath(N);

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.hasHamiltonianPath()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}