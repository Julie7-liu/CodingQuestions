/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        int closest = 0;
        if(numbers == null || numbers.length == 0){
            return closest;
        }
        
        Arrays.sort(numbers);
        
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length - 2; i++){
            
            int left = i + 1;
            int right = numbers.length - 1;
            
            while(left < right){
                sum = numbers[i] + numbers[left] + numbers[right];
                if(Math.abs(target - sum) < diff){
                    diff = Math.abs(target - sum);
                    closest = sum;
                }
                
                if(sum == target){
                    break;
                }else if(sum < target){
                    left ++;
                }else{
                    right --;
                }
            }
        }
        
        return closest;
    }
}

