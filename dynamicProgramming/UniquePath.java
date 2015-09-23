/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] cnt = new int[m][n];
        cnt[0][0] = 1;
        for(int i = 1; i < m; i ++){
            cnt[i][0] = cnt[i - 1][0];
        }
        for(int j = 1; j < n; j ++){
            cnt[0][j] = cnt[0][j - 1];
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++){
                cnt[i][j] = cnt[i - 1][j] + cnt[i][j - 1];
            }
        }
        
        return cnt[m - 1][n - 1];
    }
}


