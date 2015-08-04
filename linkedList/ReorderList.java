//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//You must do this in-place without altering the nodes' values

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
     * @param head: The head of linked list.
     * @return: void
     */
     
    public void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        
        // split by middle
        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        
        // reverse right
        right = reverse(right);
        
        // merge intervally
        merge(head, right);
    }
     
    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null){
             return head;
        }
         
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
         
        return slow;
    }
     
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
         
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;
        }
         
        return prev;
    }
    
    public void merge(ListNode left, ListNode right){
        int index = 0;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null){
            if(index % 2 == 0){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            
            cur = cur.next;
            index ++;
        }
        
        if(left != null){
            cur.next = left;
        }else{
            cur.next = right;
        }
    }
}


