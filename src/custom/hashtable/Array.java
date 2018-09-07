package custom.hashtable;

import java.util.Arrays;

class Array<K, V> {
    Bucket[] buckets;
    static final int DEFAULT_SIZE = 16;
    int limit;
    int filledSlots;
    double loadingFactor;
    
    Array() {
        limit = DEFAULT_SIZE;
        filledSlots = 0;
        loadingFactor = 0.75;
    }
    
    void add(K key, V value) {
        if (buckets == null) buckets = new Bucket[limit];
        
        if (filledSlots + 1 >= (loadingFactor * limit)) {
            resize();
        }
        
        int i = findSlot(key);
        if (buckets[i] == null) buckets[i] = new Bucket();
        buckets[i].add(new Node(new Entry(key, value)));
        
        filledSlots += 1;
    }
    
    int findSlot(K key) {
        return key.hashCode() % limit;
    }
    
    private synchronized void resize() {
        limit *= 2;
        // Copy elements of old buckets into new buckets with the new limit parameter.
        buckets = Arrays.copyOf(buckets, limit);
    }
}
