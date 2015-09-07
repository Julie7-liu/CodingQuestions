/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    //solution 1: hashset
    public int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];
        
        if(numbers == null || numbers.length == 0){
            return rs;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i);
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                rs[0] = i + 1;
                rs[1] = map.get(target - numbers[i]) + 1;
                break;
            }
        }
        
        return rs;
    }
    
    // //solution 2: two pointers, do not apply for this question, since we can not sort
    // public int[] twoSum(int[] numbers, int target) {
    //     int[] rs = new int[2];
    //     if(numbers == null || numbers.length == 0){
    //         return rs;
    //     }
        
    //     int start = 0;
    //     int end = numbers.length - 1;
    //     while(start < end){
    //         if(numbers[start] + numbers[end] == target){
    //             rs[0] = start + 1;
    //             rs[1] = end + 1;
    //             break;
    //         }else if(numbers[start] + numbers[end] < target){
    //             start ++;
    //         }else{
    //             end --;
    //         }
    //     }
        
    //     return rs;
    // }
}

