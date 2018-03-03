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
public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || root == p || root == q){
          return root;
      }

      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if(left != null && right != null){
          return root;
      }

      if(left != null){
          return left;
      }

      if(right != null){
          return right;
      }

      return null;
    }
}
