/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        String[] words = s.trim().split(" ");
        
        s = words[words.length - 1].trim();
        for(int i = words.length - 2; i >= 0; i--){
            if(s.trim() == ""){
                continue;
            }
            
            s += " " + words[i];
        }
        
        return s;
        
    }
}


