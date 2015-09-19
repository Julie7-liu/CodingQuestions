/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = num.length - 1;
        int mid;
        while(start + 1 < end){
            mid = (start + end) / 2;
            if(num[mid] > num[end]){
                start = mid;
            }else if(num[mid] < num[end]){
                end = mid;
            }else{ //if equals
                end --;
            }
        }
        
        return Math.min(num[start], num[end]);
    }
}

