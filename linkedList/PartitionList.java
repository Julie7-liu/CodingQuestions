//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        
        ListNode cur = head;
        ListNode leftCur = dummyLeft;
        ListNode rightCur = dummyRight;
        while(cur != null){
            if(cur.val < x){
                leftCur.next = cur;
                leftCur = leftCur.next;
            }else{
                rightCur.next = cur;
                rightCur = rightCur.next;
            }
            cur = cur.next;
        }
        
        leftCur.next = dummyRight.next;
        rightCur.next = null;
        
        return dummyLeft.next;
    }
}




