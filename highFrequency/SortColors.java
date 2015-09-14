/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int start = 0;
        int end = nums.length - 1;
        // first pass to seperate 0 and 1
        while(start < end){
            if(nums[start] == 0){
                start ++;
                continue;
            }
            
            if(nums[end] == 1 || nums[end] == 2){
                end --;
                continue;
            }
            
            swap(nums, start, end);
            start ++;
            end --;
        }
        
        // re-init start and end indices
        if(nums[start] == 0){
            start ++;
        }
        end = nums.length - 1;
        // second pass to seperate 1 and 2
        while(start < end){
            if(nums[start] == 1){
                start ++;
                continue;
            }
            
            if(nums[end] == 2){
                end --;
                continue;
            }
            
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
    
    public void swap(int[] nums, int m, int n){
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}

