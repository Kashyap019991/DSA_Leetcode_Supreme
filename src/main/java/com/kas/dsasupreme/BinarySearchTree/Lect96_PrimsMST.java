
package com.kas.dsasupreme.BinarySearchTree;
//
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class NodePrim {
	int v;
	int wt;

	NodePrim(int v, int wt) {
		this.v = v;
		this.wt = wt;
	}
}
//ref:https://www.scaler.com/topics/data-structures/shortest-path-in-directed-acyclic-graph/
public class Lect96_PrimsMST {

	static Map<Integer, List<NodePrim>> adjList = new TreeMap<Integer, List<NodePrim>>();

	//create adjList
	static void addEdgesInWeightedUnDir(int u, int v, int wt) {

		// u -> v
		if (adjList.get(u) == null) {
			// create new List and add to map as val
			adjList.put(u, new ArrayList<NodePrim>(Arrays.asList(new NodePrim(v, wt))));
		} else {
			// insert element in already created List
			adjList.get(u).add(new NodePrim(v, wt));
		}
		if (adjList.get(v) == null) {
			// create new List and add to map as val
			adjList.put(v, new ArrayList<NodePrim>(Arrays.asList(new NodePrim(u, wt))));
		} else {
			// insert element in already created List
			adjList.get(v).add(new NodePrim(u, wt));
		}
	}

	//print adjlist 1 -> [2,3],[3,4]
	static void printAdjList() {
		// for each key from keyset
		for (int key : adjList.keySet()) {
			List<NodePrim> nodes = adjList.get(key);
			System.out.println(key + "  ->  ");
			for(NodePrim node:nodes)
				System.out.println("["+node.v +" "+ node.wt +"]");
		}
	}
	
		
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data no. nodes:");
		int n = sc.nextInt();
		System.out.println("Enter data no. edges:");
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			// take input as edges i.e 2-> 3
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			addEdgesInWeightedUnDir(u, v, w);
	
		}
		//take src as input
		int src = sc.nextInt();
		
		
		printAdjList();
		
		//create weight array & initialize src index with 0
		int[] key_weight = new int[n];
		Arrays.fill(key_weight, Integer.MAX_VALUE);
		key_weight[src] = 0;
		
		//create visited/mst array
		Boolean[] mst_visited = new Boolean[n];
		Arrays.fill(mst_visited, false);
		
		//create parent array
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		
		for(int itr = 0;itr<n;itr++) {
			//find min in key_weight && mst_visited should false
			int mini = Integer.MAX_VALUE;
			int u = 0;
			for(int i=0;i<key_weight.length;i++)
			{
				if(key_weight[i] < mini && mst_visited[i] == false)
					{
					mini = key_weight[i];
					u =i;
					}
					
			}
			
			//make mst_visi[u] to true
			mst_visited[u] = true;
			
			// iterate over adjacency list for u
			for(NodePrim node:adjList.get(u)) {
				if(key_weight[node.v] > node.wt)
					{
					key_weight[node.v] = node.wt;
					parent[node.v] = u; 
					}
			}
		
		}
		
		//print output : parent[i] - i --> weight
		System.out.println("Minimum spannig Tree:");
		for(int dest = 1; dest<n;dest++) {
			System.out.println(parent[dest] +" - " + dest +" : " + key_weight[dest]);
		}
	}
}
/*
 
u v wt

/*
5
6
0 1 2
0 3 6
1 3 8
1 4 5
1 2 3
2 4 7
0

o/p:
Minimum spannig Tree:
0 - 1 : 2
1 - 2 : 3
0 - 3 : 6
1 - 4 : 5
 */
