package linkedlist;

public class SinglyLinkedList<T> {
    private LinkedListNode<T> head;
    
    void append(T data) {
        if (data == null) return;
        
        if (head == null) {
            head = new LinkedListNode<>(data);
            return;
        }
        
        LinkedListNode<T> end = new LinkedListNode<>(data);
        
        LinkedListNode<T> n = head;
        
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
    
    void delete(T data) {
        if (data == null || head == null) return;
        
        LinkedListNode<T> n = head;
        if (n.data.equals(data)) {
            head = head.next;
        }
        
        while (n.next != null) {
            if (n.next.data.equals(data)) {
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }
    
    class LinkedListNode<T> {
        LinkedListNode<T> next;
        T data;
        
        private LinkedListNode(T data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.delete("c");
    }
}
