//Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        int n1 = -1;
        int n2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;
        for(Integer n : nums){
            if(n == n1){
                cnt1 ++;
            }else if(n == n2){
                cnt2 ++;
            }else if(cnt1 == 0){
                n1 = n;
                cnt1 ++;
            }else if(cnt2 == 0){
                n2 = n;
                cnt2 ++;
            }else{
                cnt1 --;
                cnt2 --;
            }
        }
        
        cnt1 = 0;
        cnt2 = 0;
        for(Integer n : nums){
            if(n == n1){
                cnt1 ++;
            }else if(n == n2){
                cnt2 ++;
            }
        }
        
        return (cnt1 > cnt2) ? n1 : n2;
    }
}


