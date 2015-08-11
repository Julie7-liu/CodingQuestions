//Given a list of numbers with duplicate number in it. Find all unique permutations.

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            return rs;
        }
        
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.size()];
        for(boolean v: visited){
            v = false;
        }
        helper(rs, list, nums, visited);
        return rs;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> list, ArrayList<Integer> nums, boolean[] visited){
        if(list.size() == nums.size()){
            rs.add(new ArrayList(list));
            return;
        }
        
        for(int i = 0; i < nums.size(); i++){
            if(visited[i] == true || (i != 0 && nums.get(i) == nums.get(i - 1)) && visited[i - 1] == false){
                continue;
            }
            
            list.add(nums.get(i));
            visited[i] = true;
            helper(rs, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}


