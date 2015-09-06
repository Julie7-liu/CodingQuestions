//The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. 

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        int len = hashTable.length * 2;
        ListNode[] newTable = new ListNode[len];
        
        for(ListNode node: hashTable){
            while(node != null){
                int val = node.val;
                int hash = (val % len + len) % len;
                ListNode newNode = new ListNode(val);
                if(newTable[hash] == null){
                   newTable[hash] = newNode;
                }else{
                    //append newNode to the end of the list of this hash
                    ListNode cur = newTable[hash];
                    while(cur.next != null){
                       cur = cur.next;
                    }
                   cur.next = newNode;
                }
                
                node = node.next;
            }
        }
        
        return newTable;
    } 
};


