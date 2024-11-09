class MyHashMap {
    private int[] map;

    public MyHashMap() {
        // Initialize the map array with a size of 10^6 + 1 and set all values to -1
        map = new int[1_000_001];
        // Fill the array with -1 to signify that a key-value pair does not exist
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        map[key] = value; // Insert or update the value at the index corresponding to the key
    }
    
    public int get(int key) {
        return map[key]; // Return the value if it exists, otherwise return -1
    }
    
    public void remove(int key) {
        map[key] = -1; // Set the value at the index corresponding to the key to -1 (removing it)
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
