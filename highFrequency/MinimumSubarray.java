/* Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
     
    //solution 1: cal max subarray of the opposite numbers 
    public int minSubArray(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int oppositeSum = 0;
        for(int i = 0; i < nums.size(); i ++){
            if(oppositeSum < 0){
                oppositeSum = 0;
            }
            
            oppositeSum -= nums.get(i);
            min = Math.min(min, - oppositeSum);
        }
        
        return min;
    }
    
    // // solution 2: brute-force
    // public int minSubArray(ArrayList<Integer> nums){
    //     if(nums == null || nums.size() == 0){
    //         return 0;
    //     }
        
    //     int size = nums.size();
    //     int min = Integer.MAX_VALUE;
    //     int sum = 0;
    //     for(int i = 0; i < size; i ++){
    //         for(int j = i; j < size; j ++){
    //             if(i == j){
    //                 sum = nums.get(i);
    //             }else{
    //                 sum += nums.get(j);
    //             }
                
    //             min = Math.min(min, sum);
    //         }
    //     }
        
    //     return min;
    // }
}

 
