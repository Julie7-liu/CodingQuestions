//Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums){
        int candidate = 0;
        int cnt = 0;
        for(Integer n : nums){
            if(cnt == 0){
                candidate = n;
                cnt ++;
            }else{
                if(n == candidate){
                    cnt ++;
                }else{
                    cnt --;
                }
            }
        }
        
        return candidate;
    }
}


