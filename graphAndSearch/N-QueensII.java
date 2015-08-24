//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the total number of distinct solutions.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int cnt = 0;
     
    public int totalNQueens(int n) {
        int[] cols = new int[n];
        
        placeQueen(cols, 0);
        return cnt;
    }
    
    public void placeQueen(int[] cols, int row){
        int n = cols.length;
        if(row == n){
            cnt ++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isValid(cols, row, i)){
                cols[row] = i;
                placeQueen(cols, row + 1);
            }
        }
    }
    
    public boolean isValid(int[] cols, int row, int col){
        for(int i = 0; i < row; i++){
            // if same col
            if(cols[i] == col){
                return false;
            }
            
            // if in the lower left to upper right diagnal
            if(i + cols[i] == row + col){
                return false;
            }
            
            // if in the upper left to lower right diagnal
            if(i - cols[i] == row - col){
                return false;
            }
        }
        
        return true;
    }
};



