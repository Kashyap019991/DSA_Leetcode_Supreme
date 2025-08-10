
package com.kas.dsasupreme._10_Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Lect89_directedGraphDFSGraph {
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

	static ArrayList<Integer> ans = new ArrayList<>();

	static void dfsTrav(int nVertices) {
		Stack<Integer> q = new Stack<Integer>();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		Map<Integer, Boolean> onStack = new HashMap<Integer, Boolean>();
		// Map<Integer,Integer> parent = new HashMap<Integer,Integer>();
		for (int nodes = 0; nodes < nVertices; nodes++) {
			// if(nodes ==0)
			// parent.put(nodes, -1);
			if (visited.get(nodes) == null) {
				q.add(nodes);
				// DfsCurr.put(nodes, true);

				while (q.size() != 0) {
					int fnode = q.peek();
		//			DfsCurr.put(fnode, false);
					// not added in map means not visited
					
					//onStack.put(fnode, false);
					if (visited.get(fnode) == null) {
						// add into visited
						visited.put(fnode, true);
						onStack.put(fnode, true);
						// add fnode to ans
						ans.add(fnode);
					}
					else
					{
						q.pop();
						onStack.put(fnode, false);
					}
					// add neighbour into queue
					// below if to check if vertices has no neghbour
					if (adjList.get(fnode) != null) {
						for (int nbr : adjList.get(fnode)) {
							if (visited.get(nbr) == null)// check if not visited
							{
								q.add(nbr);
							
							}
							else if (onStack.get(nbr) == true) {
								//already visited and onstack bhi true
								System.out.println("cycle detected");
								return;
							}

						}
					}
				}
			}
		}

		System.out.println("cycle not detected");

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
		dfsTrav(n);

		System.out.println("DFS Trav: " + ans);
	}

	/*
	 3
	 3
	 0 1
	 0 2
	 1 2
	 
	 cycle not detected
DFS Trav: [0, 2, 1]

	 */
	/*
	 3
	 3
	 0 1
	 1 2
	 2 0
	 
	 cycle detected
DFS Trav: [0, 1, 2]
	 */
	/*
	 5
	 5
	 0 1
	 1 2
	 2 0
	 1 3
	 2 4
	 cycle detected
DFS Trav: [0, 1, 3, 2]
	 */
	/*
	 4
	 4
	 0 1
	 2 0
	 2 1
	 3 2
	 
	 cycle not detected
DFS Trav: [0, 1, 2, 3]
	 */
}
