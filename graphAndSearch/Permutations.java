//Given a list of numbers, return all possible permutations.

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
     
    // graph DFS
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            return rs;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rs, list, nums);
        return rs;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> list, ArrayList<Integer> nums){
        if(list.size() == nums.size()){
            // make a copy of the current list and add to result;
            rs.add(new ArrayList(list));
            return;
        }
        
        for(Integer n: nums){
            if(!list.contains(n)){
                list.add(n);
                helper(rs, list, nums);
                // remove the added number!!
                list.remove(n);
            }
        }
    }
}




