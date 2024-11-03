import java.util.HashMap;

class MapSum {

    // TrieNode class to store the sum and child nodes
    private class TrieNode {
        int sum;
        HashMap<Character, TrieNode> children;

        TrieNode() {
            sum = 0;
            children = new HashMap<>();
        }
    }

    private TrieNode root;
    private HashMap<String, Integer> map;

    /** Initialize the MapSum object */
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    /** Insert the key-value pair */
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);  // Calculate the difference if key exists
        map.put(key, val);  // Update or insert the key with its new value

        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());  // Insert node if it doesn't exist
            curr = curr.children.get(c);
            curr.sum += delta;  // Update sum at each node in the path
        }
    }

    /** Return the sum of all values with keys starting with the prefix */
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null) {
                return 0;  // No such prefix found
            }
        }
        return curr.sum;  // Return the sum at the end of the prefix path
    }
}
