/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 0){
                path[i][0] = path[i - 1][0];
            }else{
                path[i][0] = 0;
            }
        }
        for(int j = 1; j < n; j++){
            if(obstacleGrid[0][j] == 0){
                path[0][j] = path[0][j - 1];
            }else{
                path[0][j] = 0;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }else{
                    path[i][j] = 0;
                }
            }
        }
        
        return path[m - 1][n - 1];
    }
}

