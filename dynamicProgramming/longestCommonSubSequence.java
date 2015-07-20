//Given two strings, find the longest common subsequence (LCS).
//Your code should return the length of LCS.

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    // dynamic programming, O(m*n)
    public int longestCommonSubsequence(String A, String B) {
        if( A == null || B == null || A.length() == 0 || B.length() == 0 ){
            return 0;
        }
        
        int m = A.length();
        int n = B.length();
        int[][] subSeqLen = new int[m][n];
        for(int i = 0; i < m; i++){
            subSeqLen[i][0] = (A.charAt(i) == B.charAt(0)) ? 1 : 0;
        }
        for(int j = 0; j < n; j++){
            subSeqLen[0][j] = (A.charAt(0) == B.charAt(j)) ? 1 : 0;
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(A.charAt(i) == B.charAt(j)){
                    subSeqLen[i][j] = subSeqLen[i - 1][j - 1] + 1;
                }else{
                    subSeqLen[i][j] = Math.max(subSeqLen[i - 1][j], subSeqLen[i][j - 1]);
                }
            }
        }
        
        return subSeqLen[m - 1][n - 1];
    }
}


