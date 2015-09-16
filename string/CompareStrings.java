//Compare two strings A and B, determine whether A contains all of the characters in B.

//The characters in string A and B are all Upper Case letters.

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if(A == null || B == null){
            return false;
        }
        
        int[] cnt = new int[256];
        int index;
        for(int i = 0; i < A.length(); i++){
            index = (int) A.charAt(i);
            cnt[index] += 1;
        }
        
        for(int i = 0; i < B.length(); i++){
            index = (int) B.charAt(i);
            cnt[index] -= 1;
            
            if(cnt[index] < 0){
                return false;
            }
        }
        
        return true;
    }
}

