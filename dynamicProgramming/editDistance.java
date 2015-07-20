/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
*/

public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if( word1 == null || word2 == null){
            return 0;
        }
        
        int m = word1.length();
        int n = word2.length();
        int[][] dist = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i ++){
            dist[i][0] = i;
        }
        for(int j = 0; j <= n; j ++){
            dist[0][j] = j;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dist[i][j] = dist[i - 1][j - 1];
                }else{
                    // possible edit paths:
                    // 1. replaces word1's i-th character with word2's j-th character: dist[i - 1][j - 1] + 1
                    // 2. delete word1's i-th character: dist[i - 1][j] + 1
                    // 3. insert word2's j-th character at word1's i-th character: dist[i][j - 1] + 1
                    // dist[i][j] = Math.min(dist[i - 1][j - 1], dist[i - 1][j]);
                    // dist[i][j] = Math.min(dist[i][j], dist[i][j - 1]) + 1;
                    dist[i][j] = 1 + Math.min(dist[i - 1][j - 1], Math.min(dist[i - 1][j], dist[i][j - 1]));
                }
            }
        }
        
        return dist[m][n];
    }
}

