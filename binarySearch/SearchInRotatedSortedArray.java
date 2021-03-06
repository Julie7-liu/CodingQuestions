/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        int mid;
        while(start + 1 < end){
            mid = (start + end) / 2;
            
            if(A[mid] == target){
                return mid;
            }
            
            if(A[mid] > A[start]){
                if(A[start] <= target && A[mid] > target){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(A[mid] < target && A[end] >= target){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(A[start] == target){
            return start;
        }else if(A[end] == target){
            return end;
        }else{
            return -1;
        }
    }
}


