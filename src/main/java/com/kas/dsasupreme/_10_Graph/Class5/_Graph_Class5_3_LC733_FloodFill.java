package com.kas.dsasupreme._10_Graph.Class5;

import java.util.*;

class Point {
	int row;
	int col;

	Point(int row2, int col2) {
		this.row = row2;
		this.col = col2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return row == point.row && col == point.col;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
}

class Graph_Class5_NoOfIsland {

	public int[][] ans = null;
	public HashMap<Point, Boolean> visited = new HashMap<>();

	void dfs(int x, int y , int oldColor, int newColor){
		//1st visited mark kr do
		visited.put(new Point(x,y),true);
		//2nd check for next pos
		int[] dx= {-1,0, 1,  0};
		int[] dy= {0, 1, 0, -1};

		//move in all 4 dir
		for(int i =0 ; i<4 ;i++){
			//1. check x&y in boundary
			//2.new newx & newy not visited
			int newx = x + dx[i];
			int newy = y + dy[i];
			if(newx >= 0 && newx < ans.length && newy >= 0 && newy <ans[1].length
					&& visited.get(new Point(newx,newy) )== null && ans[newx][newy] == oldColor)
			{
				ans[newx][newy] = newColor;
				dfs(newx, newy, oldColor, newColor);
			}
		}
	}
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		ans = image;
		int oldColor = image[sr][sc];
		//if(oldColor ==1)
		ans[sr][sc] = color;
		dfs(sr,sc,oldColor,color);

        return ans;
    }

	public static void main(String[] args) {
		int[][] image = {{0,0,0},{0,0,0}};
				//{ {1,1,1},{1,1,0},{1,0,1} };

		Graph_Class5_NoOfIsland gcnop = new Graph_Class5_NoOfIsland();
		int[][] floodFIlled = gcnop.floodFill(image,0,0,0);
		for(int i = 0;i<floodFIlled.length;i++) {
			System.out.println(Arrays.toString(floodFIlled[i]));
		}
	}
}