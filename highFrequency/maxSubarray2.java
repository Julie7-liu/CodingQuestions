//Given an array of integers, find two non-overlapping subarrays which have the largest sum.
//The number in each subarray should be contiguous.
//Return the largest sum.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums){
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int n = nums.size();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        int leftMax[] = new int[n - 1];
        for(int i = 0; i < n -1; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMax[i] = max;
        }
        
        //re-init everything
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        int rightMax[] = new int[n - 1];
        for(int j = n - 2; j >= 0; j --){
            sum += nums.get(j + 1);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[j] = max;
        }
        
        max = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            max = Math.max(max, leftMax[i] + rightMax[i]);
        }
        
        return max;
    } 
}





