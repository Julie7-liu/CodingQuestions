//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//The same repeated number may be chosen from C unlimited number of times.

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        
        if(candidates == null){
            return rs;
        }
        
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        helper(rs, list, candidates, target, 0);
        return rs;
    }
    
    public void helper(List<List<Integer>> rs, List<Integer> list, int[] candidates, int target, int pos){
        if(target == 0){
            rs.add(new ArrayList(list));
            return;
        }
        
        int prev = -1;
        for(int i = pos; i < candidates.length; i++ ){
            //if already bigger, exit this level
            if(candidates[i] > target){
                break;
            }
            
            // if duplicate, skip
            if(prev != -1 && candidates[i] == prev){
                continue;
            }
            
            list.add(candidates[i]);
            helper(rs, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
	    
	    prev = candidates[i];
        }
    }
}


// public class Solution {
//     /**
//      * @param candidates: A list of integers
//      * @param target:An integer
//      * @return: A list of lists of integers
//      */
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> rs = new ArrayList<List<Integer>>();
//         if(candidates.length == 0 || target == 0){
//             return rs;
//         }
        
//         Arrays.sort(candidates);
//         List<Integer> list = new ArrayList<Integer>();
//         helper(rs, list, 0, candidates, target, 0);
//         return rs;
//     }
    
//     public void helper(List<List<Integer>> rs, List<Integer> list, int sum, int[] candidates, int target, int pos){
//         if(sum == target){
//             rs.add(new ArrayList(list));
//             return; 
//         }else if(sum > target){
//             return;
//         }
        
//         for(int i = pos; i < candidates.length; i ++){
//             list.add(candidates[i]);
//             helper(rs, list, sum + candidates[i], candidates, target, i);
//             list.remove(list.size() - 1);
//         }
//     }
// }

