package linkedlist;

public class SinglyLinkedList<T> {
    LinkedListNode<T> head;
    
    public SinglyLinkedList(){}
    
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
            return;
        }
        
        while (n.next != null) {
            if (n.next.data.equals(data)) {
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }
    
    void print() {
        LinkedListNode<T> n = head;
        
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
    
    class LinkedListNode<E> {
        LinkedListNode<E> next;
        E data;
        
        LinkedListNode(E data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("a");
        list.append("b");
        list.append("c");
        list.append("d");
        list.delete("c");
        list.print();
    }
}
