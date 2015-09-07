//Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> rs = new ArrayList<Integer>();
        if(A == null || A.length == 0){
            return rs;
        }
        
        //find the bit that is different between these two single numbers
        int xor = 0;
        for(int n : A){
            xor ^= n;
        }
        
        int diffBit = xor - (xor & (xor - 1));
        int group1 = 0;
        int group2 = 0;
        // classify numbers based on the last different bit
        for(int n : A){
            if((n & diffBit) == 0){
                group1 ^= n;
            }else{
                group2 ^= n; 
            }
        }
        
        rs.add(group1);
        rs.add(group2);
        return rs;
    }
}

