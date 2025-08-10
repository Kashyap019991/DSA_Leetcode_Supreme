//using searhing tc: O(V^2)
package com.kas.dsasupreme._10_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

class Nodedij {
	int v;
	int wt;

	Nodedij(int v, int wt) {
		this.v = v;
		this.wt = wt;
	}
}
//ref:https://www.scaler.com/topics/data-structures/shortest-path-in-directed-acyclic-graph/
public class Lect95_ShortestPathInUndirctedDijkstra {

	static Map<Integer, List<Nodedij>> adjList = new TreeMap<Integer, List<Nodedij>>();

	//create adjList
	static void addEdgesInWeightedUnDir(int u, int v, int wt) {

		// u -> v
		if (adjList.get(u) == null) {
			// create new List and add to map as val
			adjList.put(u, new ArrayList<Nodedij>(Arrays.asList(new Nodedij(v, wt))));
		} else {
			// insert element in already created List
			adjList.get(u).add(new Nodedij(v, wt));
		}
		if (adjList.get(v) == null) {
			// create new List and add to map as val
			adjList.put(v, new ArrayList<Nodedij>(Arrays.asList(new Nodedij(u, wt))));
		} else {
			// insert element in already created List
			adjList.get(v).add(new Nodedij(u, wt));
		}
	}

	//print adjlist 1 -> [2,3],[3,4]
	static void printAdjList() {
		// for each key from keyset
		for (int key : adjList.keySet()) {
			List<Nodedij> nodes = adjList.get(key);
			System.out.println(key + "  ->  ");
			for(Nodedij node:nodes)
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
		
		
		//find shortest path
		
		//1. create ans array initialize it with INF & put 0 dist for src
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		//2. create min heap returns <int,int><dist,v> based on min distance
		PriorityQueue<Nodedij> minHeapWt = new PriorityQueue<>(new Comparator<Nodedij>() {
			@Override
			public int compare(Nodedij o1, Nodedij o2) {
				return o1.wt - o2.wt;//min heap			
			}

		});
		
		//initialize minHeap with source node and 0 dist
		minHeapWt.add(new Nodedij(src, 0));
		
		while(!minHeapWt.isEmpty()){
			//pop min dist nodedij from min Heap
			Nodedij fnode = minHeapWt.poll();
			
			//now iterate on nbr of fnode
			for(Nodedij nbr:adjList.get(fnode.v)){
				//check curr dist[u] > newly calculate then replace in dist and add to 
				//minheap
				if(dist[nbr.v] > dist[fnode.v] + nbr.wt)
				{
					dist[nbr.v] = dist[fnode.v] + nbr.wt;
					minHeapWt.add(new Nodedij(nbr.v, nbr.wt));
				}
			}
		}
		System.out.println("ans"+Arrays.toString(dist));
	}
}
/*
 
u v wt
4
5
0 1 5
0 2 8
1 2 9
1 3 2
2 3 6
0
dist from 0 to all node [0, 5, 8, 7]
*/
/*
5
7
0 1 7
0 2 1
0 3 2
1 2 3
1 3 5
1 4 1
3 4 7
0

ans[0, 4, 1, 2, 5]
 */
