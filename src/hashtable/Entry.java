package hashtable;

class Entry<K, V> {
    private K key;
    private V value;
    
    Entry(K key, V value) {
        Entry.this.key = key;
        Entry.this.value = value;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (!(o instanceof Entry)) return false;
        
        Entry entry = (Entry) o;
        return entry.key.equals(this.key) && entry.value.equals(this.value);
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
}
