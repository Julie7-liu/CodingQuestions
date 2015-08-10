//Given a list of numbers that may has duplicate numbers, return all possible subsets//

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        
        if(S == null || S.size() == 0){
            return rs;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);
        helper(rs, list, S, 0);
        return rs;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> list, ArrayList<Integer> S, int pos){
        rs.add(new ArrayList(list));
        
        for(int i = pos; i < S.size(); i++){
            // do not add if the same level already has this number
            if(i != pos && S.get(i) == S.get(i - 1)){
                continue;
            }
            
            list.add(S.get(i));
            helper(rs, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
}


