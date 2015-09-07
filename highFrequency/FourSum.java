/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
*/
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) { 
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length == 0){
            return rs;
        }
        
        Arrays.sort(numbers);
        
        for(int i = 0; i < numbers.length - 3; i++){
            if(i != 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            for(int j = i + 1; j < numbers.length - 2; j++){
                if(j != i + 1 && numbers[j] == numbers[j - 1]){
                    continue;
                }
                
                int start = j + 1;
                int end = numbers.length - 1;
                int sum = 0;
                ArrayList<Integer> list;
                while(start < end){
                    sum = numbers[i] + numbers[j] + numbers[start] + numbers[end];
                    if(sum == target){
                        list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[start]);
                        list.add(numbers[end]);
                        rs.add(list);
                        
                        start ++;
                        end --;
                        while(start < end && numbers[start] == numbers[start - 1]){
                            start ++;
                        }
                        while(start < end && numbers[end] == numbers[end + 1]){
                            end --;
                        }
                    }else if(sum < target){
                        start ++;
                    }else{
                        end --;
                    }
                }
            }
        }
        return rs;
    }
}


