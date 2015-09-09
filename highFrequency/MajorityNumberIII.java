//Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if(nums == null || nums.size() == 0){
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else if(map.size() < k){
                map.put(n, 1);
            }else{
                // cannot remove while iterating (will throw ConcurrentModificationException)
                ArrayList<Integer> removeList = new ArrayList<Integer>();
                Set<Integer> keys = map.keySet();
                for(Integer key : keys){
                    if(map.get(key) == 1){
                        removeList.add(key);
                    }else{
                        map.put(key, map.get(key) - 1);
                    }
                }
                
                for(Integer key: removeList){
                    map.remove(key);
                }
            }
        }
        
        int majority = -1;
        int max = 0;
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            if(map.get(key) > max){
                max = map.get(key);
                majority = key;
            }
        }
        
        return majority;
    }
}


