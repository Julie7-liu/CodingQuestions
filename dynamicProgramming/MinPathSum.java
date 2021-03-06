/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int min = 0;
        if(grid.length == 0){
            return min;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        // state
        int[][] sum = new int[m][n];
        
        // init
        sum[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        
        for(int j = 1; j < n; j++){
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                //function
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        
        //answer
        return sum[m - 1][n - 1];
    }
}


