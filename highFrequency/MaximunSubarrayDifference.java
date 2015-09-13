/*
Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int size = nums.size();
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];
        int[] minLeft = new int[size];
        int[] minRight = new int[size];
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < size; i++){
            if(sum < 0){
                sum = 0;
            }
            
            sum += nums.get(i);
            max = Math.max(sum, max);
            maxLeft[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        sum = 0;
        for(int i = size - 1; i >= 0; i--){
            if(sum < 0){
                sum = 0;
            }
            
            sum += nums.get(i);
            max = Math.max(sum, max);
            maxRight[i] = max;
        }
        
        int min = Integer.MAX_VALUE;
        int oppositeSum = 0;
        for(int i = 0; i < size; i++){
            if(oppositeSum < 0){
                oppositeSum = 0;
            }
            
            oppositeSum -= nums.get(i);
            min = Math.min(- oppositeSum, min);
            minLeft[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        oppositeSum = 0;
        for(int i = size - 1; i >= 0; i--){
            if(oppositeSum < 0){
                oppositeSum = 0;
            }
            
            oppositeSum -= nums.get(i);
            min = Math.min(- oppositeSum, min);
            minRight[i] = min;
        }
        
        int maxDiff = Integer.MIN_VALUE;
        int diff1, diff2;
        for(int i = 0; i < size - 1; i++){
            diff1 = Math.abs(maxLeft[i] - minRight[i + 1]);
            diff2 = Math.abs(maxRight[i + 1] - minLeft[i]);
            maxDiff = Math.max(maxDiff, Math.max(diff1, diff2));
        }
        
        return maxDiff;
    }
}



