/*
Given a string which contains only letters. Sort it by lower case first and upper case second.
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if(chars == null || chars.length == 0){
            return;
        }
        
        int start = 0;
        int end = chars.length - 1;
        char tmp;
        while(start < end){
            if(Character.isLowerCase(chars[start])){
                start ++;
                continue;
            }
            
            if(Character.isUpperCase(chars[end])){
                end --;
                continue;
            }
            
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start ++;
            end --;
        }
    }
}


