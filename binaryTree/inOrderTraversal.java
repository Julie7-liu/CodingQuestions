//Given a binary tree, return the inorder traversal of its nodes' values.

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
     * @return: Inorder in ArrayList which contains node values.
     */
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> rs = new ArrayList<Integer>();
    //     helper(root, rs);
    //     return rs;
    // }
    
    // public void helper(TreeNode root, ArrayList<Integer> rs){
    //     if(root == null){
    //         return;
    //     }
        
    //     helper(root.left, rs);
    //     rs.add(root.val);
    //     helper(root.right, rs);
    // }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<Integer>();
        if(root == null){
            return rs;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            rs.add(cur.val);
            cur = cur.right;
        }
        
        return rs;
    }
}

