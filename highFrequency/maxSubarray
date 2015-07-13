//Given an array of integers, find a contiguous subarray which has the largest sum.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    //solution 1: dynamic programming
    public int maxSubArray(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        int sum = 0;
        
        int minSum = 0;
        for(int i = 0; i < nums.size(); i++){
            // prefix sum of i numbers
            sum += nums.get(i);
            // sum - minSum: the max sub array sum that ends with number i
            // max: current max sub array sum (up to numbers ends with i)
            max = Math.max(max, sum - minSum);
            // the min out of all i prefix sum
            minSum = Math.min(minSum, sum);
        }
        
        return max;
    }
    
    // //solution 2: greedy
    // public int maxSubArray(ArrayList<Integer> nums){
    //     if(nums == null || nums.size() == 0){
    //         return 0;
    //     }
        
    //     int max = Integer.MIN_VALUE;
    //     int sum = 0;
    //     for(int i = 0; i < nums.size(); i++){
    //         sum += nums.get(i);
    //         max = Math.max(max, sum);
    //         // if sum is smaller than 0, do not take those numbers
    //         sum = Math.max(0, sum);
    //     }
        
    //     return max;
    // }
    
}

