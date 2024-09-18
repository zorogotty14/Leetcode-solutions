import java.util.*;

class AllOne {

    private class BucketNode {
        int count;
        Set<String> keys;
        BucketNode prev;
        BucketNode next;

        BucketNode(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, BucketNode> keyNodeMap;
    private BucketNode head;
    private BucketNode tail;

    /** Initialize your data structure here. */
    public AllOne() {
        keyNodeMap = new HashMap<>();
        head = new BucketNode(Integer.MIN_VALUE); // head sentinel
        tail = new BucketNode(Integer.MAX_VALUE); // tail sentinel
        head.next = tail;
        tail.prev = head;
    }
    
    /** Increments the count of the string key by 1. */
    public void inc(String key) {
        if (!keyNodeMap.containsKey(key)) {
            // Key does not exist, insert with count 1
            if (head.next == tail || head.next.count > 1) {
                // Insert new bucket with count 1 after head
                BucketNode newNode = new BucketNode(1);
                insertAfter(head, newNode);
            }
            head.next.keys.add(key);
            keyNodeMap.put(key, head.next);
        } else {
            // Key exists, increment its count
            BucketNode currNode = keyNodeMap.get(key);
            int currCount = currNode.count;
            BucketNode nextNode = currNode.next;
            currNode.keys.remove(key);

            if (nextNode == tail || nextNode.count > currCount + 1) {
                // Insert new bucket with count currCount + 1 after currNode
                BucketNode newNode = new BucketNode(currCount + 1);
                insertAfter(currNode, newNode);
                nextNode = newNode;
            }
            nextNode.keys.add(key);
            keyNodeMap.put(key, nextNode);

            if (currNode.keys.isEmpty()) {
                remove(currNode);
            }
        }
    }
    
    /** Decrements the count of the string key by 1. */
    public void dec(String key) {
        BucketNode currNode = keyNodeMap.get(key);
        int currCount = currNode.count;
        currNode.keys.remove(key);

        if (currCount == 1) {
            // Key count becomes 0, remove it
            keyNodeMap.remove(key);
        } else {
            BucketNode prevNode = currNode.prev;
            if (prevNode == head || prevNode.count < currCount - 1) {
                // Insert new bucket with count currCount - 1 before currNode
                BucketNode newNode = new BucketNode(currCount - 1);
                insertAfter(prevNode, newNode);
                prevNode = newNode;
            }
            prevNode.keys.add(key);
            keyNodeMap.put(key, prevNode);
        }

        if (currNode.keys.isEmpty()) {
            remove(currNode);
        }
    }
    
    /** Returns one of the keys with maximal count. */
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal count. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    // Helper method to insert newNode after node
    private void insertAfter(BucketNode node, BucketNode newNode) {
        newNode.prev = node;
        newNode.next = node.next;
        node.next.prev = newNode;
        node.next = newNode;
    }

    // Helper method to remove a node from the linked list
    private void remove(BucketNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
