
package com.kas.dsasupreme._10_Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Lect90_TopoLogicalSort_DfsDirectedAcyclicgraph {
	// we are using set instead of list bcoz we need ordered neighbour
	static Map<Integer, Set<Integer>> adjList = new TreeMap<Integer, Set<Integer>>();

	static void addEdges(int u, int v, int directed) {

		if (adjList.get(u) == null) {
			adjList.put(u, new HashSet<>(Arrays.asList(v)));
		} else
			adjList.get(u).add(v);

		// undirected then add reverse
		if (directed == 0) {
			if (adjList.get(v) == null) {
				adjList.put(v, new HashSet<>(Arrays.asList(u)));
			} else
				adjList.get(v).add(u);
		}
	}


	static Stack<Integer> ansSortTopo = new Stack<Integer>();
	static void topoSortDAG(int nVertices) {
		Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
		Stack<Integer> dfsCall = new Stack<Integer>(); //to do : check rhs remove type int
		for(int node=0;node < nVertices;node++){
			//here we can define start from 0 or 1 in above for loop
			if(visited.get(node) == null){
				dfsCall.add(node);
				
				while(!dfsCall.isEmpty()){
					int fnode = dfsCall.peek();
					if(visited.get(fnode) == null){
						//not visited
						visited.put(fnode, true);
					}
					else{
						dfsCall.pop();
						//add to ans stack while return call and all its nbr visited
						ansSortTopo.add(fnode);
					}
					
					if(adjList.get(fnode) != null){
						for(int nbr:adjList.get(fnode)){
							if(visited.get(nbr) == null)
								dfsCall.add(nbr);
						}
					}
					
				}
			}
		}
		
		
	}

	public static void main(String args[])

	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data no. nodes:");
		int n = sc.nextInt();
		System.out.println("Enter data no. edges:");
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			// take input as edges i.e 2-> 3
			int u = sc.nextInt();
			int v = sc.nextInt();

			// 0 means undirected , 1 means directed
			// prepare adjacecny list
			addEdges(u, v, 1);
		}

		/*
		 * for(int key:adjList.keySet()){
		 * 
		 * System.out.println(key +" -> "+adjList.get(key)); }
		 */

		// Dfs traversal
		// adjlist
		// int src = sc.nextInt();

		// n is no.of vertex
		topoSortDAG(n);
		Iterator value= ansSortTopo.iterator();
		
		System.out.println("Topological sort:");
		/*while(value.hasNext())
			System.out.print(value.next());*/
		while(!ansSortTopo.isEmpty())
			System.out.println(ansSortTopo.pop());
	}

/*
 6
 7
 1 2
 1 3
 2 4
 3 4
 4 5
 4 6
 5 6
 
 
 */
/*
 6
 6
 5 2
 5 0
 4 0
 4 1
 2 3
 3 1
 
 {2=[3], 3=[1], 4=[0, 1], 5=[0, 2]}
 5 4 2 3 1 0
 */
	
/*
 4
 4
 0 1
 0 3
 1 2
 3 2

 */
}
