/* 
Given an array of integers, find two non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int len = nums.size();
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < len; i ++){
            if(sum < 0){
                sum = 0;
            }
            
            sum += nums.get(i);
            max = Math.max(max, sum);
            maxLeft[i] = max; 
        }
        
        max = Integer.MIN_VALUE;
        sum = 0;
        for(int i = len - 1; i >= 0; i --){
            if(sum < 0){
                sum = 0;
            }
            
            sum += nums.get(i);
            max = Math.max(max, sum);
            maxRight[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        sum = 0;
        // each subarray should have at least one number
        for(int i = 0; i < len - 1; i++){
            sum = maxLeft[i] + maxRight[i + 1];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}




