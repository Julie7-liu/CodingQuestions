//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
     
    private ListNode cur;
    
    public TreeNode sortedListToBST(ListNode head) {  
        cur = head;
        int size = getSize(head);
        
        return helper(size);
    }
    
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size ++;
            head = head.next;
        }
        
        return size;
    }
    
    public TreeNode helper(int size){
        if(size <= 0){
            return null;
        }
        
        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(size - 1 - size / 2);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
