/*
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
       if(A == null || A.length == 0){
           return;
       }
       
       //count dominant
       int cnt = 0;
       for(int n : A){
           if(n > 0){
               cnt ++;
           }else{
               cnt --;
           }
       }
       
       if(cnt == 0){
           cnt = 1;
       }
       
       int len = A.length;
       int p1 = 0;
       int p2 = 1;
       while(p1 < len && p2 < len){
           if(A[p1] * cnt > 0){
               p1 += 2;
           }else if(A[p2] * cnt < 0){
               p2 += 2;
           }else{
               int tmp = A[p1];
               A[p1] = A[p2];
               A[p2] = tmp;
               p1 += 2;
               p2 += 2;
           }
       }
   }
}

