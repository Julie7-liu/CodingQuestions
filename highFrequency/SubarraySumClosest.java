/*
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    // solution 1: hashmap
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> rs = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return rs;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long closest = Long.MAX_VALUE;
        int sum = 0;
        map.put(0, -1);
        rs.add(-1);
        rs.add(-1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            Set<Integer> set = map.keySet();
            for(Integer key : set){
                if(Math.abs(sum - key) < closest){
                    closest = Math.abs(sum - key);
                    rs.set(0, map.get(key) + 1);
                    rs.set(1, i);
                    
                    if(closest == 0){
                        return rs;
                    }
                }
            }
            
            map.put(sum, i);
        }
        
        return rs;
    }
    
    // solution 2: sort
    // class Pair {
    //     int sum;
    //     int index;
    //     public Pair(int s, int i) {
    //         sum = s;
    //         index = i;
    //     }
    // }
    // public ArrayList<Integer> subarraySumClosest(int[] nums) {
    //     // write your code here
    //     ArrayList<Integer> res = new ArrayList<Integer> ();
    //     if (nums == null || nums.length == 0) {
    //         return res;
    //     } 
        
    //     int len = nums.length;
    //     if(len == 1) {
    //         res.add(0);
    //         res.add(0);
    //         return res;
    //     }
    //     Pair[] sums = new Pair[len+1];
    //     int prev = 0;
    //     sums[0] = new Pair(0, 0);
    //     for (int i = 1; i <= len; i++) {
    //         sums[i] = new Pair(prev + nums[i-1], i);
    //         prev = sums[i].sum;
    //     }
    //     Arrays.sort(sums, new Comparator<Pair>() {
    //       public int compare(Pair a, Pair b) {
    //           return a.sum - b.sum;
    //       } 
    //     });
        
    //     int ans = Integer.MAX_VALUE;
    //     for (int i = 1; i <= len; i++) {
            
    //         if (ans > sums[i].sum - sums[i-1].sum) {
    //             ans = sums[i].sum - sums[i-1].sum;
    //             res.clear();
    //             int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
    //             Arrays.sort(temp);
    //             res.add(temp[0] + 1);
    //             res.add(temp[1]);
    //         }
    //     }
        
    //     return res;
    // }
}


*/
