//Sort a linked list in O(n log n) time using constant space complexity.

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
// // solution 1: merge sort
// public class Solution {
//     /**
//      * @param head: The head of linked list.
//      * @return: You should return the head of the sorted linked list,
//                     using constant space complexity.
//      */
//     public ListNode sortList(ListNode head) {  
//         if(head == null || head.next == null){
//             return head;
//         }
        
//         ListNode middle = findMiddle(head);
        
//         // split into two parts
//         ListNode right = sortList(middle.next);
//         middle.next = null;
//         ListNode left = sortList(head);

//         return mergeTwoLists(left, right);
//     }
    
//     public ListNode findMiddle(ListNode head){
//         ListNode p1 = head;
//         ListNode p2 = head.next;
        
//         while(p2 != null && p2.next != null){
//             p1 = p1.next;
//             p2 = p2.next.next;
//         }
        
//         return p1;
//     }
    
//     public ListNode mergeTwoLists(ListNode left, ListNode right){
//         ListNode dummy = new ListNode(0);
        
//         ListNode cur = dummy;
//         while(left != null && right != null){
//             if(left.val < right.val){
//                 cur.next = left;
//                 left = left.next;
//             }else{
//                 cur.next = right;
//                 right = right.next;
//             }
//             cur = cur.next;
//         }
        
//         if(left != null){
//             cur.next = left;
//         }
//         if(right != null){
//             cur.next = right;
//         }
        
//         return dummy.next;
//     }
// }

//solution 2: quick sort
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMiddle(head);
        // head = partitionList(head, mid.val);
        
        // ListNode right = sortList(mid.next);
        // mid.next = null;
        
        ListNode leftDummy = new ListNode(0);
        ListNode midDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        
        ListNode cur = head;
        ListNode leftCur = leftDummy;
        ListNode midCur = midDummy;
        ListNode rightCur = rightDummy;
        while(cur != null){
            if(cur.val < mid.val){
                leftCur.next = cur;
                leftCur = leftCur.next;
            }else if(cur.val > mid.val){
                rightCur.next = cur;
                rightCur = rightCur.next;
            }else{
                midCur.next = cur;
                midCur = midCur.next;
            }
            cur = cur.next;
        }
        
        
        leftCur.next = null;
        midCur.next = null;
        rightCur.next = null;
        leftDummy.next = sortList(leftDummy.next);
        rightDummy.next = sortList(rightDummy.next);
        
        ListNode leftTail = findTail(leftDummy);
        leftTail.next = midDummy.next;
        ListNode midTail = findTail(midDummy);
        midTail.next = rightDummy.next;
        
        return leftDummy.next;
    }
    
    public ListNode findMiddle(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        return p1;
    }
    
    public ListNode findTail(ListNode head){
        if(head == null){
            return head;
        }
        
        while(head.next != null){
            head = head.next;
        }
        
        return head;
    }
}


