/*
Medium 3 Sum Show result 

19% Accepted
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
/*

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        
        if(numbers == null || numbers.length == 0){
            return rs;
        }
        
        Arrays.sort(numbers);
        //enum one number, find two sum of the rest numbers
        for(int i = 0; i < numbers.length - 1; i++){
            // skip duplicates
            if(i != 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            
            twoSum(numbers, rs, i, 0 - numbers[i]);
        }
        
        return rs;
    }
    
    public void twoSum(int[] numbers, ArrayList<ArrayList<Integer>> rs, int i, int target){
        if(numbers == null || numbers.length == 0){
            return;
        }
        
        int start = i + 1;
        int end = numbers.length - 1;
        ArrayList<Integer> set;
        while(start < end){
           if(numbers[start] + numbers[end] == target){
                set = new ArrayList<Integer>();
                set.add(numbers[i]);
                set.add(numbers[start]);
                set.add(numbers[end]);
                rs.add(set);
                start ++;
                end --;
                
                //skip until not repeated
                while(start < end && numbers[start] == numbers[start - 1]){
                    start ++;
                }
                while(start < end && numbers[end] == numbers[end + 1]){
                    end --;
                }
            }else if(numbers[start] + numbers[end] < target){
                start ++;
            }else{
                end --;
            }
        }
    }
}

