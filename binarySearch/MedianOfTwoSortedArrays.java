/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if(A == null || B == null){
            return 0.0;
        }
        
        int len = A.length + B.length;
        if(len % 2 == 0){
            return (findKth(A, B, 0, 0, len / 2) + findKth(A, B, 0, 0, len / 2 + 1)) / 2.0;
        }else{
            return findKth(A, B, 0, 0, len / 2 + 1);
        }
    }
    
    // find the Kth element in the two sorted arrays
    public double findKth(int[] A, int[] B, int startA, int startB, int k){
        // stop condition:
        // 1. index out of bound, which means no more element in the array
        // 2. k == 1, which means the Kth number should be the next element
        if(startA >= A.length){
            return B[startB + k - 1];
        }
        
        if(startB >= B.length){
            return A[startA + k - 1];
        }
        
        if(k == 1){
            return Math.min(A[startA], B[startB]);
        }
        
        // needs to consider index out of bound
        int numberA = startA + k / 2  - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int numberB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 -1] : Integer.MAX_VALUE;
    
        if(numberA < numberB){
            return findKth(A, B, startA + k / 2, startB, k - k / 2);
        }else{
            return findKth(A, B, startA, startB + k / 2, k - k / 2);
        }
    }
}


