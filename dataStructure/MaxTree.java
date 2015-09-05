/*
Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
/*


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = new TreeNode(0);
        TreeNode topNode = new TreeNode(0);
        for(int i = 0; i <= A.length; i++){
            int cur = (i == A.length) ? Integer.MAX_VALUE : A[i];
            curNode = new TreeNode(cur);
            while(!stack.empty() && cur > stack.peek().val){
                topNode = stack.pop();
                // chose the smaller bound of left and right, use as parent
                // if right bound is parent, become left chid
                // if left bound is parent, become right child
                if(stack.empty() || stack.peek().val > cur){
                    curNode.left = topNode;
                }else{
                    stack.peek().right = topNode;
                }
            }
            stack.push(curNode);
        }
        
        return topNode;
    }
}

