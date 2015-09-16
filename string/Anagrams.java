/*
Write a method anagram(s,t) to decide if two strings are anagrams or not.
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        
        int[] cnt = new int[256];
        int index; //convert char to ASCII using int type casting
        for(int i = 0; i < s.length(); i++){
            index = (int) s.charAt(i);
            cnt[index] += 1;
        }
        
        for(int j = 0; j < t.length(); j++){
            index = (int) t.charAt(j);
            cnt[index] -= 1;
            
            if(cnt[index] < 0){
                return false;
            }
        }
        
        return true;
    }
};

