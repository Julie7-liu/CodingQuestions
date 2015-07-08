//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    // solution 1: dp
    // public boolean canJump(int[] A){
    //     if(A == null || A.length == 0){
    //         return true;
    //     }
        
    //     int n = A.length;
    //     // initialization
    //     boolean[] can = new boolean[n];
    //     can[0] = true;
    //     for(int i = 1; i < n; i++){
    //         can[i] = false;
    //     }
        
        
    //     for(int i = 1; i < n; i++){
    //         for(int j = 0; j < i; j ++){
    //             if(can[j] && A[j] + j >= i){
    //                 can[i] = true;
    //                 break;
    //             }
    //         }
    //     }
        
    //     return can[n - 1];
    // }
    
    // solution 2: greedy 
    public boolean canJump(int[] A){
        if(A == null || A.length == 0){
            return true;
        }
        
        int n = A.length;
        int max = A[0];
        for(int i = 1; i < n; i ++){
            if(max >= i && i + A[i] > max ){
                max = i + A[i];
                if(max >= n -1){
                    return true;
                }
            }
        }
        
        return false;
    }
}


