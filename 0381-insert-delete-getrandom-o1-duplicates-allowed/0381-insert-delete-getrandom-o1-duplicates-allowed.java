import java.util.*;

class RandomizedCollection {
    // List to store the elements
    private List<Integer> list;
    // Map to store the positions of elements in the list
    private Map<Integer, Set<Integer>> map;
    // Random instance to generate random indices
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        // Add the value to the list
        list.add(val);
        // Add the index of the new value to the map
        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size() - 1);
        // Return true if this is the first occurrence of the value
        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        // If the value does not exist, return false
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        
        // Get the index of the value to remove
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);
        
        // If the value is not the last element, swap it with the last element
        if (removeIdx < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(removeIdx, lastVal);
            // Update the map for the last element
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(removeIdx);
        }
        
        // Remove the last element from the list
        list.remove(list.size() - 1);
        
        // If the set of indices for the removed value is empty, remove it from the map
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        // Return a random element from the list
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
