//Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }
        
        if(root.val > k1){
            ArrayList<Integer> leftResult = searchRange(root.left, k1, k2);
            result.addAll(leftResult);
        }
        if(root.val >= k1 && root.val <= k2){
            result.add(root.val);
        }
        if(root.val < k2){
            ArrayList<Integer> rightResult = searchRange(root.right, k1, k2);
            result.addAll(rightResult);
        }
        
        return result;
    }
}

