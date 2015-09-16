/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    * Integers in each row are sorted from left to right.

    * Integers in each column are sorted from up to bottom.

    * No duplicate integers in each row or column.
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int cnt = 0;
        if(matrix == null || matrix.length == 0){
            return cnt;
        }
        
        //start from the lower left corner
        int row = matrix.length - 1;
        int col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] == target){
                cnt ++;
                row --;
                col ++;
            }else if(matrix[row][col] < target){
                // if smaller, drop col
                 col ++;
            }else{
                // if bigger, drop row
                row --;
            }
        }
        
        return cnt;
    }
}


