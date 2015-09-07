/*Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if(A == null || A.length == 0){
            return;
        }
        
        for(int i = A.length / 2; i >= 0; i --){
            // examine and adjust each sub-heap, bottom-up
            swiftDown(A, i);
        }
    }
    
    public void swiftDown(int[] A, int i){
        int len = A.length;
        int tmp;
        int small;
        
        while(i < len){
            small = i;
            if(2 * i + 1 < len && A[2 * i + 1] < A[small]){
                small = 2 * i + 1;
            }
            if(2 * i + 2 < len && A[2 * i + 2] < A[small]){
                small = 2 * i + 2;
            }
            
            if(small == i){
                break;
            }
            
            tmp = A[small];
            A[small] = A[i];
            A[i] = tmp;
            
            i = small;
        }
    }
}
:
