//Given a string s, cut s into some substrings such that every substring is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of s.

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }
        
        int n = s.length();
        // boolean[][] isParlindrome = new boolean[n][n];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < i; j++){
        //         isParlindrome[i][j] = isPalindrome(s, j, i);
        //     }
        // }
        
        int[] cut = new int[n + 1];
        cut[0] = -1;
        for(int i = 1; i <= n; i++){
            cut[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j ++){
                if(cut[j] == Integer.MAX_VALUE){
                    continue;
                }
                if(isPalindrome(s, j, i - 1)){
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                }
            }
        }
        
        return cut[n];
    }
    
    public boolean isPalindrome(String s, int start, int end){
        int n = s.length();
        while(start < end){
            if(s.charAt(start ++) != s.charAt(end --)){
                return false;
            }
        }
        
        return true;
    }
};

