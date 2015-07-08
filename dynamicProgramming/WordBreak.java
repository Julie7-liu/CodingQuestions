//Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0){
            return true;
        }   
        
        int n = s.length();
        int maxLen = getMaxLen(dict);
        boolean[] can = new boolean[n + 1];
        can[0] = true;
        for(int i = 1; i <= n; i ++){
            can[i] = false;
            for(int j = Math.max(i - maxLen, 0); j < i; j ++){
                if(can[j] == false){
                    continue;
                }
                String subStr = s.substring(j, i);
                if(dict.contains(subStr)){
                    can[i] = true;
                }
            }
        }
        
        return can[n];
            
        
    }
    
    public int getMaxLen(Set<String> dict){
        int maxLen = 0;
        for(String word: dict){
            if(word.length() > maxLen){
                maxLen = word.length();
            }
        }
        
        return maxLen;
    }
}

