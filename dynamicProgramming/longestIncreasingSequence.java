//Given a sequence of integers, find the longest increasing subsequence (LIS).

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        int n = nums.length;
        int[] longest = new int[n];
        longest[0] = 1;
        for(int i = 1; i < n; i++){
            longest[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[i]){
                    continue;
                }
                
                longest[i] = Math.max(longest[i], longest[j] + 1);
            }
            
            if(max < longest[i]){
                max = longest[i];
            }
        }
        
    
        return max;
    }
}


