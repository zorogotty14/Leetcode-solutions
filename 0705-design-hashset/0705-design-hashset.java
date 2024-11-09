class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        // Since the maximum possible key is 10^6, we create an array of size 10^6 + 1
        set = new boolean[1_000_001];
    }
    
    public void add(int key) {
        set[key] = true; // Mark the key's position as true
    }
    
    public void remove(int key) {
        set[key] = false; // Mark the key's position as false (removing it)
    }
    
    public boolean contains(int key) {
        return set[key]; // Return true if the key exists, otherwise false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
