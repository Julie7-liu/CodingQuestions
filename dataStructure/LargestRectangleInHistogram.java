//n n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        int max = 0;
        if(height == null || height.length == 0){
            return max;
        }
        
        //indices that have height smaller than the last height(ascending heights)
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i <= height.length; i++){
            int curHeight = (i == height.length) ? -1 : height[i];
            while(!stack.empty() && curHeight <= height[stack.peek()]){
                //height of the stack top
                int h = height[stack.pop()];
                //right bound is i (smaller than the poped),
                //left bound is stack top (last index that has height smaller than the poped)
                int w = stack.empty() ? i : i - stack.peek() - 1;
                int area = h * w;
                max = Math.max(max, area);
            }
            
            stack.push(i);
        }
        
        return max;
    }
}


