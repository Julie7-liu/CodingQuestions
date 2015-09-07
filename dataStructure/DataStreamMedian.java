//Numbers keep coming, return the median of numbers at every time a new number added.

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length, new MinComparator());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new MaxComparator());
        
        int[] median = new int[nums.length];
        int curMedian = nums[0];
        median[0] = curMedian;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < curMedian){
                minHeap.offer(nums[i]);
            }else{
                maxHeap.offer(nums[i]);
            }
            
            // re-calculate the current median
            if(minHeap.size() - maxHeap.size() >= 1){
                maxHeap.offer(curMedian);
                curMedian = minHeap.poll();
            }else if(maxHeap.size() - minHeap.size() > 1){
                minHeap.offer(curMedian);
                curMedian = maxHeap.poll();
            }
            
            median[i] = curMedian;
        }
        
        return median;
    }
    
    public class MinComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer x, Integer y){
            return y - x;
        }
    }
    
    public class MaxComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer x, Integer y){
            return x - y;
        }
    }
}

