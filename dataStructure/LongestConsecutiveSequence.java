//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        int len = 0;
        if(num == null || num.length == 0){
            return len;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        // init set
        for(int n: num){
            set.add(n);
        }
        
        int min, max, curLen;
        for(int n: num){
            if(!set.contains(n)){
                continue;
            }
            
            set.remove(n);
            
            min = n - 1;
            max = n + 1;
            curLen = 1;
            while(set.contains(min)){
                set.remove(min);
                min --;
                curLen ++;
            }
            while(set.contains(max)){
                set.remove(max);
                max ++;
                curLen ++;
            }
            
            len = Math.max(len, curLen);
        }
        
        return len;
    }
}

