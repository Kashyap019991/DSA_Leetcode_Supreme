package com.kas.dsasupreme._10_Graph.Class5;

import java.util.*;

class Pair {
	int row;
	int col;

	int time;
	Pair(int row2, int col2, int t) {
		this.row = row2;
		this.col = col2;
		this.time = t;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair pair = (Pair) o;
		return row == pair.row && col == pair.col && time == pair.time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col, time);
	}
}

class _Graph_Class5_LC994_RottenOranges {


	int orangesRotting(int[][] grid) {
		int[][] copyGrid = grid;

		Queue<Pair> rottenq = new LinkedList();

		//insert all rotten oranges in Queue
		int freshOranges =0;
		int n = grid.length;
		int m = grid[0].length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j<m ; j++){
				if(copyGrid[i][j] == 2)
				{
					rottenq.add(new Pair(i, j, 0));
				} else if (copyGrid[i][j] ==1) {
					freshOranges++;
				}
			}
		}

		//now traverse bfs to find minTime to rot oranges
		int minTimeAns = 0;
		int freshOrangesCount = 0;
		while (!rottenq.isEmpty()){

			//pop rotten oranges
			Pair frontRottenOrange = rottenq.poll();
			int x = frontRottenOrange.row;
			int y = frontRottenOrange.col;
			int time = frontRottenOrange.time;
			//check in all 4 direction of frontRottenOrange
			int dx[] = {0, 0 , 1, -1};
			int dy[] = {1,-1,0,0};

			for(int i = 0; i<4; i++){
				int newx = x + dx[i];
				int newy  = y + dy[i];

				if(newx >=0 && newx <n && newy>=0 && newy < m && copyGrid[newx][newy] ==1){
					//make it rotten
					copyGrid[newx][newy] = 2;
					//find max Time till now
					minTimeAns = Math.max(time+1, minTimeAns);
					//insert in queue by increment time by 1
					rottenq.add(new Pair(newx, newy, time+1));
					freshOrangesCount++;
				}
			}
		}
		if(freshOrangesCount != freshOranges)
			return -1;
        return minTimeAns;
    }

	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
				//{ {1,1,1},{1,1,0},{1,0,1} };

		_Graph_Class5_LC994_RottenOranges gcnop = new _Graph_Class5_LC994_RottenOranges();
		int ansTime = gcnop.orangesRotting(grid);
		System.out.println(ansTime);
	}
}