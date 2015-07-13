//Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    //solution 1: Hash
    public ArrayList<Integer> subarraySum(int[] nums){
        ArrayList<Integer> res = new ArrayList<Integer>();
        // key: prefix sum of 1 to start - 1; value: start - 1;
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        int sum = 0;
        sumMap.put(sum, 0);
        for(int i = 1; i <= nums.length; i ++){
            sum += nums[i - 1];
            if(sumMap.containsKey(sum)){
                res.add(sumMap.get(sum));
                res.add(i - 1);
                return res;
            }
            
            sumMap.put(sum, i);
        }
        
        return res;
    } 
    
     
    ////solution 2: brute-force 
    // public ArrayList<Integer> subarraySum(int[] nums) {
    //     ArrayList<Integer> res = new ArrayList<Integer>();
        
    //     int n = nums.length;
    //     int[][] sub = new int[n][n];
    //     //sub array starts with i and end with j
    //     for(int i = 0; i < n; i ++){
    //         sub[i][i] = nums[i];
    //         if(sub[i][i] == 0){
    //             res.add(i);
    //             res.add(i);
    //             return res;
    //         }
    //         for(int j = i + 1; j < n; j ++){
    //             sub[i][j] = sub[i][j - 1] + nums[j];
    //             if(sub[i][j] == 0){
    //                 res.add(0, i);
    //                 res.add(1, j);
    //                 return res;
    //             }
    //         }
    //     }
        
    //     return res;
    // }
}

