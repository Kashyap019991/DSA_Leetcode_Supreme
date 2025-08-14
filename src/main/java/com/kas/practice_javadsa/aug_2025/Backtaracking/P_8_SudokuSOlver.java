package com.kas.practice_javadsa.aug_2025.Backtaracking;

class P_8_SudokuSOlver {

    /**
     * Solves the Sudoku puzzle by filling in the empty cells represented by '.'
     * The solution is modified in-place within the provided board.
     * @param board The 9x9 Sudoku board to be solved.
     */
    public void solveSudoku(char[][] board) {
        // Start the recursive solving process from the beginning of the board (row 0, col 0)
        solve(board);
    }


    private boolean solve(char[][] board) {
        // Iterate through each cell of the 9x9 board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If the current cell is empty ('.')
                if (board[row][col] == '.') {
                    // Try numbers from '1' to '9' in the empty cell
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if placing 'num' at (row, col) is valid according to Sudoku rules
                        if (isValid(board, row, col, num)) {
                            // If valid, place the number temporarily
                            board[row][col] = num;

                            // Recursively attempt to solve the rest of the board with the new number placed
                            if (solve(board)) {
                                return true; // If a solution is found in the recursive call, return true
                            } else {
                                // If the current path doesn't lead to a solution (recursive call returned false),
                                // backtrack: reset the cell to empty and try the next number
                                board[row][col] = '.';
                            }
                        }
                    }
                    // If no number from '1' to '9' leads to a solution for the current empty cell,
                    // return false to trigger backtracking in the previous recursive call
                    return false;
                }
            }
        }
        // If the entire board is filled (no empty cells found), a solution has been found
        return true;
    }

    /**
     * Checks if placing a given number at a particular cell is valid according to Sudoku rules.
     * A number is valid if it's not present in the same row, column, or 3x3 subgrid.
     * @param board The Sudoku board.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @param num The number to be checked for validity.
     * @return True if the number is valid to be placed, false otherwise.
     */
    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row: Iterate through the row to see if 'num' already exists
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check column: Iterate through the column to see if 'num' already exists
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid: Determine the starting row and column of the current 3x3 subgrid
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        // Iterate through the 3x3 subgrid to see if 'num' already exists
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        // If 'num' is not found in the row, column, or 3x3 subgrid, it's a valid placement
        return true;
    }
}