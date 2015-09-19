//Given a rotated sorted array, recover it to sorted array in-place.

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return;
        }
        
        for(int i = 1; i < nums.size(); i ++){
            if(nums.get(i) < nums.get(i - 1)){
                swap(nums, 0, i - 1);
                swap(nums, i, nums.size() - 1);
                swap(nums, 0, nums.size() - 1);
            }
        }
    }
    
    public void swap(ArrayList<Integer> nums, int start, int end){
        while(start < end){
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start ++;
            end --;
        }
    }
}

