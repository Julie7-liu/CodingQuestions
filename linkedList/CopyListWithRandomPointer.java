//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
     
    // Solution 2: copy in place
    public RandomListNode copyRandomList(RandomListNode head){
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        
        // copy next, and insert
        RandomListNode cur = dummy.next;
        RandomListNode copy, tmp;
        while(cur != null){
            copy = new RandomListNode(cur.label);
            tmp = cur.next;
            cur.next = copy;
            copy.next = tmp;
            
            cur = cur.next.next;
        }
        
        // copy random
        cur = dummy.next;
        while(cur != null && cur.next != null){
            if(cur.random != null){
                tmp = cur.random;
                cur.next.random = tmp.next;
            }
            
            cur = cur.next.next;
        }
        
        // split
        cur = dummy;
        while(cur != null && cur.next != null){
            tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = null;
            
            cur = cur.next;
        }
        
        return dummy.next;
    }
     
    //  // Solution 1: hash map
    //  public RandomListNode copyRandomList(RandomListNode head){
    //      HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
         
    //      RandomListNode dummy = new RandomListNode(0);
    //      RandomListNode copyDummy = new RandomListNode(0);
    //      map.put(dummy, copyDummy);
    //      dummy.next = head;
    //      RandomListNode cur = dummy;
    //      RandomListNode nextNode, randomNode;
    //      while(cur != null){
    //          if(cur.next != null){
    //              if(!map.containsKey(cur.next)){
    //                  nextNode = new RandomListNode(cur.next.label);
    //                  map.put(cur.next, nextNode);
    //              }else{
    //                  nextNode = map.get(cur.next);
    //              }
                 
    //              map.get(cur).next = nextNode;
    //          }
             
             
    //          if(cur.random != null){
    //              if(!map.containsKey(cur.random)){
    //              randomNode = new RandomListNode(cur.random.label);
    //              map.put(cur.random, randomNode);
    //              }else{
    //                  randomNode = map.get(cur.random);
    //              } 
    //              map.get(cur).random = randomNode;
    //          }
            
    //          cur = cur.next;
             
    //      }
         
    //      return copyDummy.next;
    //  }
     
     
    // // Solution 1: hash map
    // public RandomListNode copyRandomList(RandomListNode head) {
    //     if(head == null){
    //         return null;
    //     }
        
    //     // traverse list to construct hashmap, make copy of data only
    //     HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    //     RandomListNode cur = head;
    //     RandomListNode newNode;
    //     while(cur != null){
    //         newNode = new RandomListNode(cur.label);
    //         map.put(cur, newNode);
    //         cur = cur.next;
    //     }
        
    //     // copy next and random pointers
    //     cur = head;
    //     while(cur != null){
    //         newNode = map.get(cur);
    //         newNode.next = map.get(cur.next);
    //         newNode.random = map.get(cur.random);
    //         cur = cur.next;
    //     }
        
    //     return map.get(head);
    // }
    
    // public RandomListNode copyRandomList(RandomListNode head){
    //     RandomListNode dummy = new RandomListNode(0);
    //     dummy.next = head;
        
    //     HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
    //     RandomListNode prev = dummy;
    //     RandomListNode cur, newNode;
    //     while(prev.next != null){
    //         cur = prev.next;
    //         if(map.containsKey(cur)){
    //             newNode = map.get(cur);
    //         }else{
    //             newNode = new RandomListNode(cur.label);
    //             map.put(cur, newNode);
    //         }
            
    //         map.get(prev).next = newNode;
            
    //         if(!map.containsKey(prev.random)){
    //           newNode = new RandomListNode(prev.random.label);
    //           map.put(prev.random, newNode);
    //         }
    //         map.get(prev).next = 
    //     }
    // }
    
    
}



