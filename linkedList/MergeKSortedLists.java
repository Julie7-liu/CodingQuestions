//Merge k sorted linked lists and return it as one sorted list.

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
 
// solution 1: priority queue
// public class Solution {
//     /**
//      * @param lists: a list of ListNode
//      * @return: The head of one sorted list.
//      */
//     public ListNode mergeKLists(List<ListNode> lists) {  
//         if(lists == null || lists.size() == 0){
//             return null;
//         }
        
//         PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        
//         for(ListNode list: lists){
//             if(list != null){
//                 heap.add(list);
//             }
//         }
        
//         ListNode dummy = new ListNode(0);
//         ListNode cur = dummy;
//         while(heap.size() > 0){
//             ListNode tmp = heap.poll();
//             cur.next = tmp;
//             cur = cur.next;
            
//             if(tmp.next != null){
//                 heap.add(tmp.next);
//             }
//         }
        
//         return dummy.next;
//     }
    
//     private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
//         public int compare(ListNode l1, ListNode l2){
//             if(l1 == null){
//                 return -1;
//             }else if(l2 == null){
//                 return 1;
//             }else{
//                 return l1.val - l2.val;
//             }
//         }
//     };
// }

// solution 2: divide and conquer
public class Solution{
    public ListNode mergeKLists(List<ListNode> lists){
        if(lists == null || lists.size() == 0){
            return null;
        }
        
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    
    public ListNode mergeHelper(List<ListNode> lists, int start, int end){
        if(start == end){
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode l1 = mergeHelper(lists, start, mid);
        ListNode l2 = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }
    
    // public ListNode mergeKLists(List<ListNode> lists){
    //     if(lists == null || lists.size() == 0){
    //         return null;
    //     }
        
    //     int n = lists.size();
    //     if(n == 1){
    //         return lists.get(0);
    //     }
        
    //     // ps: subList(int fromIndex, int toIndex)
    //     // fromIndex is inclusive, while toIndex is exclusive
    //     ListNode l1 = mergeKLists(lists.subList(0, (n - 1) / 2 + 1));
    //     ListNode l2 = mergeKLists(lists.subList((n - 1) / 2 + 1, n));
    //     return mergeTwoLists(l1, l2);
    // }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            
            cur = cur.next;
        }
        
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        
        return dummy.next;
    }
}



