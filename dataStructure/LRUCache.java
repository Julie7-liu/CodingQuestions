/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class Solution {
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    
    public class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        //remove node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        insertAtTail(node);
        
        return node.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        //if key already present
        if(get(key) != -1){
            map.get(key).val = value;
            return;
        }
        
        if(map.size() == capacity){
            map.remove(head.next.key);
            //remove at head
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        //insert at tail
        insertAtTail(newNode);
    }
    
    public void insertAtTail(Node cur){
        tail.prev.next = cur;
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev = cur;
    }
}

