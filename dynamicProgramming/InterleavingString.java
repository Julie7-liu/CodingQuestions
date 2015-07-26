//Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
    
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        
        //init
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i ++){
            if(s3.charAt(i - 1) == s1. charAt(i - 1)){
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int j = 1; j <= n; j ++){
            if(s3.charAt(j - 1) == s2.charAt(j - 1)){
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                if((s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1])){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[m][n]; 
    }
}


