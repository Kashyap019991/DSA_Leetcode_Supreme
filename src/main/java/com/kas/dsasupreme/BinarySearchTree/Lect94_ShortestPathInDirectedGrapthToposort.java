
package com.kas.dsasupreme.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

class NodeWt {
	int v;
	int wt;

	NodeWt(int v, int wt) {
		this.v = v;
		this.wt = wt;
	}
}
//ref:https://www.scaler.com/topics/data-structures/shortest-path-in-directed-acyclic-graph/
public class Lect94_ShortestPathInDirectedGrapthToposort {

	static Map<Integer, List<NodeWt>> adjList = new TreeMap<Integer, List<NodeWt>>();

	//create adjList
	static void addEdgesInWeightedDir(int u, int v, int wt) {

		// u -> v
		if (adjList.get(u) == null) {
			// create new List and add to map as val
			adjList.put(u, new ArrayList<NodeWt>(Arrays.asList(new NodeWt(v, wt))));
		} else {
			// insert element in already created List
			adjList.get(u).add(new NodeWt(v, wt));
		}
	}

	//print adjlist 1 -> [2,3],[3,4]
	static void printAdjList() {
		// for each key from keyset
		for (int key : adjList.keySet()) {
			List<NodeWt> nodes = adjList.get(key);
			System.out.println(key + "  ->  ");
			for(NodeWt node:nodes)
				System.out.println("["+node.v +" "+ node.wt +"]");
		}
	}
	
	static Stack<Integer> topologicalSort(int nNodes){
		//to store ans
		Stack<Integer> ans = new Stack<Integer>();
		Map<Integer,Integer> visited = new HashMap<Integer,Integer>();
		Stack<Integer> callStack = new Stack<Integer>();
		for(int node = 0;node<nNodes;node++){
			//check if not visited
			if(visited.get(node) == null){
				
				//add to stack
				callStack.add(node);
				
				while(!callStack.isEmpty()){
					
					int fnode = callStack.peek();//peek front element
					//check visited 
					if(visited.get(node) == null){
						//not visited then make visited true
						visited.put(fnode, 1);
					}
					else{
						//already visited then pop it and store it in ans
						callStack.pop();
						ans.add(fnode);
					}
					
					//check if fnode has nbr
					if(adjList.get(fnode) != null){
						//iterate for nbr from adj list
						for(NodeWt nodNbr:adjList.get(fnode)){
							if(visited.get(nodNbr.v) == null){
								//if not visited then add to stack
								callStack.add(nodNbr.v);
							}
						}
					}
				}
			}
		}
		return ans;
	}
	//find topologocal sort	
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
			addEdgesInWeightedDir(u, v, w);
	
		}
		//take src as input
		int src = sc.nextInt();
		
		
		printAdjList();
		
		//topological sort
		Stack<Integer> topoSortStack = topologicalSort(n);
		
		//find shortest path
		
		//1. create ans array initialize it with INF & put 0 dist for src
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		//2. iterate stack of topological sort
		while(!topoSortStack.isEmpty()){
			
			int top = topoSortStack.pop();
			
			if(dist[top] != Integer.MAX_VALUE){
				if(adjList.get(top) != null){
					for(NodeWt nbr:adjList.get(top)){
						// If distance of src->v is greater than
	                    // distance of src->u + u->v then update
	                    // the value as shown. top = 1,dst[1] =0 , nbr of 1 => [2,2][3,6] 
						// dist[2]= inf,dist[3] =inf
						if(dist[nbr.v] > dist[top]+nbr.wt){
							//dist[2] > dist[1] + wt, inf > 0+2
							dist[nbr.v] = dist[top] + nbr.wt;
							//dist[2] = 0+2;
						}
					}
				}
			}
		}
		//print ans
		System.out.println("dist from" + src+ " to all node " + 
				Arrays.toString(dist));
	}
}
/*
 
u v wt
6
9
0 1 5
0 2 3
1 2 2
1 3 6
2 3 7
2 4 4
2 5 2
3 4 -1
4 5 -2
1
dist from1 to all node [2147483647, 0, 2, 6, 5, 3]
*/