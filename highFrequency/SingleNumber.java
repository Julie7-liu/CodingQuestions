//Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

public class Solution {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
	    int rs = 0;
	    
	    if(A == null || A.length == 0){
	        return rs;
	    }
	    
		for(int n : A){
		    rs ^= n;
		}
		
		return rs;
	}
}



