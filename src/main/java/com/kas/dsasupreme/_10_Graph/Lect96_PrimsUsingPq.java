package com.kas.dsasupreme._10_Graph;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//using priority queue: tc: E(logV) 
public class Lect96_PrimsUsingPq {

  static class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }
  }

  static class Graph {
    int vertices;
    List<Edge> edges;

    public Graph(int vertices) {
      this.vertices = vertices;
      this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
      edges.add(new Edge(source, destination, weight));
    }
  }

  static class Node implements Comparable<Node> {
    int vertex, weight;

    public Node(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
      return this.weight - other.weight;
    }
  }

  public static void prims(Graph graph, int source) {
    int vertices = graph.vertices;
    boolean[] visited = new boolean[vertices];
    int[] parent = new int[vertices];
    int[] weight = new int[vertices];

    // Initialize the arrays
    for (int i = 0; i < vertices; i++) {
      visited[i] = false;
      weight[i] = Integer.MAX_VALUE;
      parent[i] = -1;
    }

    // Set the weight of the source vertex to 0
    weight[source] = 0;

    // Create a priority queue to store the vertices
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(source, 0));

    // Repeat until the queue is empty
    while (!queue.isEmpty()) {
      // Extract the minimum weight vertex from the queue
      Node node = queue.poll();
      int vertex = node.vertex;
      visited[vertex] = true;

      // Update the weight and parent of the adjacent vertices
      for (Edge edge : graph.edges) {
        int destination = edge.destination;
        if (edge.source == vertex && !visited[destination]) {
          if (weight[destination] > edge.weight) {
            weight[destination] = edge.weight;
            parent[destination] = vertex;
            queue.add(new Node(destination, weight[destination]));
          }
        }
      }
    }

    // Print the minimum spanning tree
    for (int i = 1; i < vertices; i++) {
      System.out.println(parent[i] + " - " + i + " : " + weight[i]);
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1, 2);
    graph.addEdge(0, 3, 6);
    graph.addEdge(1, 3, 8);
    graph.addEdge(1, 4, 5);
    graph.addEdge(1, 2, 3);
    graph.addEdge(2, 4, 7);
    prims(graph, 0);
  }
}
