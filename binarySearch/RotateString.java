//Given a string and an offset, rotate string by offset. (rotate from left to right)

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if(str == null || str.length == 0 || offset <= 0){
            return;
        }
         
        int len = str.length;
        offset %= len; 
        reverse(str, 0, len - 1 - offset);
        reverse(str, len - offset, len - 1);
        reverse(str, 0, len - 1);
    }
    
    public void reverse(char[] str, int start, int end){
        char tmp;
        while(start < end){
            tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start ++;
            end --;
        }
    }
}

