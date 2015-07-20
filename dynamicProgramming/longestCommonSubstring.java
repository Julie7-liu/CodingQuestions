//Given two strings, find the longest common substring.
//Return the length of it.

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    // solution 1: dp, time O(m*n), memory O(m*n)
    public int longestCommonSubstring(String A, String B) {
        if(A == null || A.length() == 0 || B == null || B.length() == 0){
            return 0;
        }
        
        int m = A.length();
        int n = B.length();
        int longest = 0;
        int[][] subStrLen = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i == 0 || j == 0){
                    if(A.charAt(i) == B.charAt(j)){
                        subStrLen[i][j] = 1;   
                    }else{
                        subStrLen[i][j] = 0;
                    }
                }else{
                    if(A.charAt(i) == B.charAt(j)){
                        subStrLen[i][j] = subStrLen[i - 1][j - 1] + 1;
                    }else{
                        subStrLen[i][j] = 0;
                    }
                }
                longest = Math.max(longest, subStrLen[i][j]);
            }
        }
        
        return longest;
    }
    
    // // solution 2: non-dp, time O(n^3)
    // public int longestCommonSubstring(String A, String B) {
    //     if(A == null || B == null || A.length() == 0 || B.length() == 0){
    //         return 0;
    //     }
        
    //     int m = A.length();
    //     int n = B.length();
    //     int longest = 0;
    //     for(int i = 0; i < m; i ++){
    //         for(int j = 0; j < n; j ++){
    //             if(A.charAt(i) != B.charAt(j)){
    //                 continue;
    //             }
                
    //             int offset = 1;
    //             int len = 1;
    //             while(offset + i < m && offset + j < n && A.charAt(offset + i) == B.charAt(offset + j)){
    //                 len ++;
    //                 offset ++;
    //             }
                
    //             longest = Math.max(longest, len);
    //         }
    //     }
        
    //     return longest;
    // }
}


