import java.util.*;

class LFUCache {
    private int capacity;
    private int minFreq;
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToLRUList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToLRUList = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        
        // Update the frequency of the key
        updateFrequency(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        // If the key is already present, update the value and frequency
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            updateFrequency(key);
            return;
        }
        
        // If the cache is full, evict the least frequently used element
        if (keyToVal.size() >= capacity) {
            evictLFU();
        }
        
        // Insert the new key
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);  // Frequency starts at 1
        
        // Add the key to the frequency list
        freqToLRUList.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;  // Since this is a new key, the minimum frequency is 1
    }
    
    private void updateFrequency(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        
        // Remove the key from the current frequency list
        freqToLRUList.get(freq).remove(key);
        if (freqToLRUList.get(freq).isEmpty()) {
            freqToLRUList.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        
        // Add the key to the new frequency list
        freqToLRUList.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }
    
    private void evictLFU() {
        // Find the least frequently used key
        LinkedHashSet<Integer> keysWithMinFreq = freqToLRUList.get(minFreq);
        int keyToEvict = keysWithMinFreq.iterator().next();
        
        // Remove this key from the cache
        keysWithMinFreq.remove(keyToEvict);
        if (keysWithMinFreq.isEmpty()) {
            freqToLRUList.remove(minFreq);
        }
        keyToVal.remove(keyToEvict);
        keyToFreq.remove(keyToEvict);
    }
}
