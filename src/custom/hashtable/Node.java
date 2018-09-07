package custom.hashtable;

public class Node {
    Entry entry;
    Node nextNode;
    Node previousNode;
    
    Node(Entry entry) {
        this.entry = entry;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + entry.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (!(o instanceof Node)) return false;
        
        Node node = (Node) o;
        return entry.equals(node.entry);
    }
}