package com.kas.dsasupreme.BinarySearch;
class SearchIn2DMatric {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length; 
        int m = matrix[0].length; 
        int e = (n * m) - 1;
        
        while(s <= e) {
            int mid = (s + (e - s) / 2);
            int rowIndex = mid/m;
            int colIndex = mid % m;
            if(target == matrix[rowIndex][colIndex]) {
                return true;
            }
            if(target > matrix[rowIndex][colIndex]) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return false;
    
    }
}