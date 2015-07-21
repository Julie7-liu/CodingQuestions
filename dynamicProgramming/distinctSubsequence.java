//Given a string S and a string T, count the number of distinct subsequences of T in S.
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if(S == null || T == null){
            return 0;
        }
        
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        // count of empty string in S's i suffix: 1
        for(int i = 0; i <= m; i ++){
            dp[i][0] = 1;
        }
        // count of T's j suffix in empty string
        for(int j = 1; j <= n; j ++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                // at least should be the same cnt as not taking S's i-th character
                dp[i][j] = dp[i - 1][j];
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    // add the cnt if equals
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}


