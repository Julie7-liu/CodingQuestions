/*
Design an iterator over a binary search tree with the following rules:

Elements are visited in ascending order (i.e. an in-order traversal)
next() and hasNext() queries run in O(1) time in average.
*/

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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    private Stack<TreeNode> stack;
    private TreeNode cur;
    
    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        this.cur = root;
        this.stack = new Stack<TreeNode>();
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (cur != null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        
        cur = stack.pop();
        TreeNode next = cur;
        cur = cur.right;
        return next;
    }
}

