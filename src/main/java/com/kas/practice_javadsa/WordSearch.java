package com.kas.practice_javadsa;
class WordSearch {
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(backtrack(r,c,board,word,0)) return true;
            }
        }
        return false;
    }
    
    boolean backtrack(int r,int c,char[][] board,String word,int ind){
        if(ind >= word.length()) return true;
        if(r < 0 ||
           c < 0 ||
           r >= rows ||
           c >= cols ||  board[r][c] != word.charAt(ind)) return false;
        
        int[] dirx = {-1,0,1,0};
        int[] diry = {0,-1,0,1};
        boolean ret = false;
        board[r][c] = '#';
        for(int dir=0;dir<4;dir++){
            int newr = r + dirx[dir];
            int newc = c + diry[dir];
            
            ret = backtrack(newr,newc,board,word,ind+1);
            
            if(ret) break;
        
        
        }
        //clean up
        board[r][c] = word.charAt(ind);
      return ret;  
    }
    public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		WordSearch sl = new WordSearch();
		System.out.println(sl.exist(board,word));
	}
    
}