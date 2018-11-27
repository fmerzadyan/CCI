package hashtable;

public class HashTable<K, V> {
    private Array table;
    
    public HashTable() {
        table = new Array();
    }
    
    public void put(K key, V value) {
        table.add(key, value);
    }
    
    public V get(K key) {
        if (key == null || table == null || table.filledSlots == 0) return null;
        
        int i = table.findSlot(key);
        Bucket bucket = table.buckets[i];
        
        if (bucket == null) return null;
        return (V) bucket.getEntry(key).getValue();
    }
    
    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable();
        table.put("A", "Alpha");
        table.put("A", "Alpha");
        table.put("B", "Bravo");
        table.put("C", "Charlie");
        
        System.out.println(table.get("B"));
    }
}
