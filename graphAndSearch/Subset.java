//Given a set of distinct integers, return all possible subsets.

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S){
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        
        if(S == null || S.size() == 0){
            return rs;
        }
        
        ArrayList<Integer> subset = new ArrayList<Integer>();
        Collections.sort(S);
        helper(rs, subset, S, 0);
        return rs;
    }
    
    // use an additional pos to mark the smallest number to add into subset
    public void helper(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> subset, ArrayList<Integer> S, int pos){
        rs.add(new ArrayList(subset));
        
        for(int i = pos; i < S.size(); i ++){
            subset.add(S.get(i));
            // new pos should be i + 1
            helper(rs, subset, S, i + 1);
            subset.remove(subset.size()  - 1);
        }
    }
    
    // public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
    //     ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
    //     if(S == null || S.size() == 0){
    //         return rs;
    //     }
        
    //     ArrayList<Integer> subset = new ArrayList<Integer>();
        
    //     helper(rs, subset, S);
    //     return rs;
    // }
    
    // public void helper(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> subset, ArrayList<Integer> S){
    //     // add to result first, do not leave out the empty set
    //     rs.add(new ArrayList(subset));
        
    //     for(Integer n: S){
    //         if(subset.size() == 0 || n > subset.get(subset.size() - 1)){
    //             subset.add(n);
    //             helper(rs, subset, S);
    //             subset.remove(n);
    //         }
    //     }
    // }
}

