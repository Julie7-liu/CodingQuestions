//Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
//The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // return the first node we find 
        if(root == null || root == A || root == B){
            return root;
        }
        
        // get the first node we find in left and right subtree respectively
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else if(left != null && right != null){
            //if one node is in left subtree and the other is in right subtree
            return root;
        }else{ // no LCA found
            return null;
        }
    }
}
