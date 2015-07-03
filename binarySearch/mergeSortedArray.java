//Given two sorted integer arrays A and B, merge B into A as one sorted array.
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(B == null || n == 0){
            return;
        }
        
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(A[i] >= B[j]){
                A[k --] = A[i --];
            }else{
                A[k --] = B[j --];
            }
        }
        
        while(j >= 0){
            A[k --] = B[j --];
        }
    }
}
