//Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
     
    // recursion solution
    // public TreeNode insertNode(TreeNode root, TreeNode node) {
    //     if(root == null){
    //         return node;
    //     }
        
    //     if(node.val < root.val){
    //         root.left = insertNode(root.left, node);
    //     }else{
    //         root.right = insertNode(root.right, node);
    //     }
        
    //     return root;
    // }
    
    // non-recursive solution
    public TreeNode insertNode(TreeNode root, TreeNode node){
        //if empty tree, add node directly
        if(root == null){
            return node;
        }
        
        TreeNode cur = root;
        while(true){
            if(node.val < cur.val){
                if(cur.left == null){
                    cur.left = node;
                    break;
                }else{
                    cur = cur.left;
                }
            }else{
                if(cur.right == null){
                    cur.right = node;
                    break;
                }else{
                    cur = cur.right;
                }
            }
        }
        
        cur = node;
        return root;
    }
}

