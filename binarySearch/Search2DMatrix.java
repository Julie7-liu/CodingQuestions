/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        int mid;
        while(start <= end){
            mid = (start + end) / 2;
            
            if(matrix[mid / n][mid % n] == target){
                return true;
            }else if(matrix[mid / n][mid % n] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        // while(start + 1 < end){
        //     mid = (start + end) / 2;
            
        //     if(matrix[mid / n][mid % n] == target){
        //         return true;
        //     }else if(matrix[mid / n][mid % n] < target){
        //         start = mid;
        //     }else{
        //         end = mid;
        //     }
        // }
        
        // if(matrix[start / n][start % n] == target || matrix[end / n][end % n] == target){
        //     return true; 
        // } 
        
        return false;
    }
}


