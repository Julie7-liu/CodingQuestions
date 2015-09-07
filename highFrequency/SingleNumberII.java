//Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        int rs = 0;
        
        if(A == null || A.length == 0){
            return rs;
        }
        
        int len = 20;
        
        //init pow3
        int[] pow3 = new int[len];
        pow3[0] = 1;
        for(int i = 1; i < len; i++){
            pow3[i] = pow3[i - 1] * 3; 
        }
        
        //calculate each bit 
        int[] bits = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < A.length; j++){
                bits[i] += A[j] / pow3[i] % 3;
            }
            bits[i] %= 3;
        }
        
        //convert back to decimal
        for(int i = 0; i < len; i++){
            rs += bits[i] * pow3[i];
        }
        
        return rs;
    }
}

