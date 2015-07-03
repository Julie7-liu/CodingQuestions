//Given a binary tree, find the maximum path sum.
//The path may start and end at any node in the tree.

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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        PathSum pathSum = helper(root);
        return pathSum.maxPath;
    }
    
    private class PathSum{
        // max path from root to any node
        int singlePath;
        // max path go through the root between two nodes
        int maxPath;
        
        public PathSum(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    public PathSum helper(TreeNode root){
        if(root == null){
            return new PathSum(0, Integer.MIN_VALUE);
        }
        
        PathSum leftPathSum = helper(root.left);
        PathSum rightPathSum = helper(root.right);
        
        // largest single path should be one of the following:
        // 1. root to any node in the left subtree
        // 2. root to any node in the right subtree
        // 3. not selecting any node, if < 0
        int singlePath = Math.max(leftPathSum.singlePath, rightPathSum.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        
        // max path should be one of the following:
        // 1. path between any two nodes in the left subtree, not including root
        // 2. path between any two nodes in the right subtree, not including root
        // 3. path go through the root between any two nodes
        // int maxPath = getMax(leftPathSum.maxPath, rightPathSum.maxPath, leftPathSum.singlePath + rightPathSum.singlePath + root.val);
        int maxPath = Math.max(leftPathSum.maxPath, rightPathSum.maxPath);
        maxPath = Math.max(maxPath, leftPathSum.singlePath + rightPathSum.singlePath + root.val);
        
        return new PathSum(singlePath, maxPath);
    } 
   
}

