package linkedlist;

public class KthLast {
    private static String getKthToLast(DoublyLinkedList<String> list, int k) {
        if (k < 0) return null;
        
        DoublyLinkedList.LinkedListNode n = list.tail;
        
        int i = 0;
        while (n != null) {
            if (i != k) {
                i++;
                n = n.prev;
            } else {
                return (String) n.data;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.append("d");
        list.append("e");
        list.append("f");
        System.out.println(getKthToLast(list, 1));
    }
}
