package com.kas.dsasupreme.extra_classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs2 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			ls.add(new ArrayList<Integer>());
		}
		/*ls.get(0).add(1);
		ls.get(0).add(3);
		ls.get(0).add(4);
		ls.get(4).add(5);
		ls.get(3).add(5);
		ls.get(1).add(2);
		ls.get(1).add(0);
		ls.get(2).add(1);
		ls.get(4).add(1);
		ls.get(3).add(1);
		ls.get(5).add(4);
		ls.get(5).add(3);*/
		/*ls.get(0).add(1);
		ls.get(1).add(0);
		ls.get(1).add(2);
		ls.get(1).add(4);
		ls.get(2).add(1);
		ls.get(2).add(3);
		ls.get(2).add(4);
		ls.get(3).add(2);
		ls.get(4).add(1);
		ls.get(4).add(2);*/
		ls.get(0).add(1);
		ls.get(0).add(2);
		ls.get(0).add(3);
		ls.get(1).add(0);
		ls.get(2).add(0);
		ls.get(3).add(0);
		ArrayList<Integer> al =traversBfs(ls);
		System.out.println(al);
//[[1],[0,2,4],[1,3,4],[2],[1,2]]
	//[[1,2,3],[0],[0],[0]]	
	}

	private static ArrayList<Integer> traversBfs(ArrayList<ArrayList<Integer>> ls) {

		int n = ls.size();
		boolean[] ar = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> al = new ArrayList<>();
		if (q.isEmpty()) {
			q.add(0);
			ar[0] = true;
		}

		while (!q.isEmpty()) {
			
			int i = q.poll();// 0
			al.add(i);
			for (Integer it : ls.get(i)) {

				if (ar[it] == false) {
					// q.add(ls.get(0).get(i));
					q.add(it);
					ar[it] = true;
				}
			}
		}
		return al;

	}
}