/*

146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  //capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4


*/


import java.util.Map;
import java.util.HashMap;

class Link {
    int key;
    Link prev = null;
    Link next = null;
    
    public Link(int val) {
        this.key = val;
    }
}

class LRUCache {
    // Time - O(1)
    // Space - O(2N) = O(N)
    // 14 ms solution.

    // Most recently used item will be at the beginning,
    // while least recently used item at the end of the linked list.

    int capacity;
    Map<Integer, Integer> keyValMap;
    Map<Integer, Link> keyLinkMap;
    Link start = null;
    int currentCap = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyValMap = new HashMap<Integer, Integer>(capacity);
        keyLinkMap = new HashMap<Integer, Link>(capacity);
    }
    
    public int get(int key) {
        int returnVal = keyValMap.getOrDefault(key, -1);
        if (returnVal == -1){
            return returnVal;
        } else {
            Link newStart = keyLinkMap.get(key);
            if (newStart == start) {
                return returnVal;
            } else {
                newStart.prev.next = newStart.next;
                if (newStart.next != null) {
                    //if not the last node
                    newStart.next.prev = newStart.prev;
                    newStart.prev = start.prev;
                }
                newStart.next = start;
                start.prev = newStart;
                start = newStart;
                return returnVal;
            }
        }
    }
    
    public void put(int key, int value) {
        if (keyValMap.containsKey(key)) {
            keyValMap.put(key, value);
            get(key);
            return;
        }
        Link newLink = new Link(key);
        if (currentCap < capacity) {
            if (start == null) {
                newLink.prev = newLink;
                start = newLink;
            } else {
                newLink.next = start;
                newLink.prev = start.prev;
                start.prev = newLink;
                start = newLink;
            }
            ++currentCap;
        } else if (capacity == 1){
            newLink.next = null;
            newLink.prev = newLink;
            keyValMap.remove(start.key);
            keyLinkMap.remove(start.key);
            start = newLink;
        } else {
            Link temp = start.prev;
            temp.prev.next = null;
            
            newLink.next = start;
            newLink.prev = temp.prev;
            start.prev = newLink;
            start = newLink;
            
            keyValMap.remove(temp.key);
            keyLinkMap.remove(temp.key);
        }
        keyLinkMap.put(key, newLink);
        keyValMap.put(key, value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache_146 {
    public static void main (String[] agrs) {
        int capacity = 10;
        LRUCache obj = new LRUCache(capacity);
        obj.put(10, 13);
        obj.put(3, 17);
        obj.put(6, 11);
        obj.put(10, 5);
        obj.put(9, 10);
        System.out.println(obj.get(13));
        obj.put(2, 19);
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
        obj.put(5, 25);
        System.out.println(obj.get(8));
        obj.put(9, 22);
        obj.put(5, 5);
        obj.put(1,30);
        System.out.println(obj.get(11));
        obj.put(9, 12);
        System.out.println(obj.get(7));
        System.out.println(obj.get(5));
        System.out.println(obj.get(8));
        System.out.println(obj.get(9));
        obj.put(4, 30);
        obj.put(9, 3);
        System.out.println(obj.get(9));
        System.out.println(obj.get(10));
        System.out.println(obj.get(10));
        obj.put(6, 14);
        obj.put(3, 1);
        obj.get(3);
        obj.put(10, 11);
        System.out.println(obj.get(8));
        obj.put(2, 14);
        System.out.println(obj.get(1));
        System.out.println(obj.get(5));
        System.out.println(obj.get(4));
        obj.put(11, 4);
        obj.put(12, 24);
        obj.put(5, 18);
        System.out.println(obj.get(13));
        obj.put(7, 23);
        System.out.println(obj.get(8));
        System.out.println(obj.get(12));
        obj.put(3, 27);
        obj.put(2, 12);
        System.out.println(obj.get(5));
        obj.put(2, 9);
        obj.put(13, 4);
        obj.put(8, 18);
        obj.put(1, 7);
        System.out.println(obj.get(6));

    }
}