package com.kas.dsasupreme.recursion;

import java.util.ArrayList;

public class RatInMaze {
	static ArrayList<String> res= new ArrayList<String>();
	public static Boolean isSafe(int newx, int newy, int n, int[][] visited, int[][] inppath) {
									
		//x and y  should be in square not outside square
		if ((newx >= 0 && newx <= n - 1) && (newy >= 0 && newy <= n - 1)
				//check it not visited otherwise will be loop
				&& visited[newx][newy] != 1
				// 1 means allowed
				&& inppath[newx][newy] == 1)
			return true;
		else
			return false;

	}

	public static void solve(int[][] inppath, int[][] visited, int x, int y, int n, StringBuilder path) {
		

		if (inppath[0][0] == 0) {
			return;
		}

		// base case
		if (x == n - 1 && y == n - 1) {
			//StringBuilder path1=path;
			res.add(path.toString());
			return;
		}

		visited[x][y] = 1;

		// down
		int newx = x + 1;
		int newy = y;
		
		if (isSafe(newx, newy, n, visited, inppath)) {
			path.append("D");
			solve(inppath, visited, newx, newy, n, path);
			path.deleteCharAt(path.length() - 1);
		}
		// left
		newx = x;
		newy = y - 1;

		if (isSafe(newx, newy, n, visited, inppath)) {
			path.append("L");
			solve(inppath, visited, newx, newy, n, path);
			path.deleteCharAt(path.length() - 1);
		}

		// Right
		newx = x;
		newy = y + 1;

		if (isSafe(newx, newy, n, visited, inppath)) {
			path.append("R");
			solve(inppath, visited, newx, newy, n, path);
			path.deleteCharAt(path.length() - 1);
		}

		// Up
		newx = x-1;
		newy = y;

		if (isSafe(newx, newy, n, visited, inppath)) {
			path.append("U");
			solve(inppath, visited, newx, newy, n, path);
			path.deleteCharAt(path.length() - 1);
		}

		//make 0 when back track otherwise new path will not be explored
		visited[x][y] = 0;

	}
	
	public static void main(String args[]) {
		int[][] inppaths ={{1, 0, 0, 0},
		{1, 1, 0, 1},
		{0, 1, 0, 0},
		{1, 1, 1, 1}};
				// { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		int rows = 4, cols = 4, n = 4;
		int[][] visited = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited[i][j] = 0;
			}
		}
		
		StringBuilder path = new StringBuilder();
		int srcx = 0, srcy = 0;
		solve(inppaths, visited, srcx, srcy, n, path);
		System.out.println(res);
	}

}
