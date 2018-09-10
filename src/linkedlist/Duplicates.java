package linkedlist;

import java.util.HashSet;

public class Duplicates {
    private static SinglyLinkedList<String> removeDuplicatesUsingHashSet(SinglyLinkedList<String> list) {
        if (list == null || list.head == null) return null;
        
        HashSet<String> set = new HashSet<>();
        SinglyLinkedList.LinkedListNode prev = null;
        SinglyLinkedList.LinkedListNode n = list.head;
        
        while (n != null) {
            if (set.contains(n.data)) {
                // Remove n by removing references to this node using prev.next = n.next.
                prev.next = n.next;
            } else {
                set.add((String) n.data);
                prev = n;
            }
            n = n.next;
        }
        
        return list;
    }
    
    private static SinglyLinkedList<String> removeDuplicatesWithoutBuffer(SinglyLinkedList<String> list) {
        SinglyLinkedList.LinkedListNode current = list.head;
        
        while (current != null) {
            SinglyLinkedList.LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data.equals(current.data)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("addy");
        list.append("maddy");
        list.append("daddy");
        list.append("baddy");
        list.append("maddy");
        
        // list = removeDuplicatesUsingHashSet(list);
        list = removeDuplicatesWithoutBuffer(list);
        list.print();
    }
}
