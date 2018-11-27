package hashtable;

import custom.hashtable.HashTable;

class Bucket<K, V> {
    private Node head;
    private Node tail;
    // Indicates whether a slot (hashtable bucket) is already established and filled by at least one node.
    int size;
    
    void add(Node node) {
        if (size == 0) {
            head = node;
            // Ensure head node is actually head node.
            head.previousNode = null;
            head.nextNode = null;
        } else if (size == 1) {
            tail = node;
            head.nextNode = tail;
        } else {
            Node temp = tail;
            tail = node;
            tail.previousNode = temp;
            // Ensure tail node is actually tail node.
            tail.nextNode = null;
        }
        
        size += 1;
    }
    
    Entry<K, V> getEntry(K key) {
        Node currentNode = head;
        
        while (currentNode != null) {
            if (!currentNode.entry.getKey().equals(key)) {
                currentNode = currentNode.nextNode;
            } else {
                return currentNode.entry;
            }
        }
        
        return null;
    }
}