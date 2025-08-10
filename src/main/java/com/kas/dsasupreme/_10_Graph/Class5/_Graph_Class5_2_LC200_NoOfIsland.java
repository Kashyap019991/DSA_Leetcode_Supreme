package com.kas.dsasupreme._10_Graph.Class5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



class _Graph_Class5_2_LC200_NoOfIsland {
	public HashMap<Point, Boolean> visited = new HashMap<Point, Boolean>();

	void numsIslandHelper(int row, int col, char[][] grid) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(row, col));
		while (!q.isEmpty()) {

			Point p = q.poll();
			visited.put(p, true);

			// dir l, r, t, d
			int[] dirx = { 0, 0, -1, 1 };
			int[] diry = { -1, 1, 0, 0 };
			int x = p.row;
			int y = p.col;

			for (int i = 0; i < 4; i++) {
				int newx = x + dirx[i];
				int newy = y + diry[i];
				if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == '1'
						&& visited.get(new Point(newx,newy)) == null) {
					q.add(new Point(newx, newy));
					visited.put(new Point(newx, newy), true);
				}
			}
		}
	}

	public int numIslands(char[][] grid) {
		int numsIsland = 0;
		int n = grid.length;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (visited.get(new Point(row, col)) == null && grid[row][col] =='1') {
					numsIslandHelper(row, col, grid);
					numsIsland++;
				}
			}
		}
		return numsIsland;
	}

	public static void main(String[] args) {
		char[][] grid = new char[][] {{'1','1','0','1','1'},{'1','0','0','0','0'},{'0','0','0','0','1'},{'1','1','0','1','1'}};
				//{ { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				//{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		_Graph_Class5_2_LC200_NoOfIsland gcnop = new _Graph_Class5_2_LC200_NoOfIsland();
		int noOfProvince = gcnop.numIslands(grid);
		System.out.println(noOfProvince);
	}
}