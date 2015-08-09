//Given a linked list, determine if it has a cycle in it.

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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) { 
        boolean hasCycle = false;
        
        if(head == null || head.next == null){
            return hasCycle;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return hasCycle;
    }
}


