class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // Start with one slot for the root
        
        for (String node : nodes) {
            slots--; // One node uses one slot
            
            if (slots < 0) {
                return false; // If slots become negative, the serialization is invalid
            }
            
            if (!node.equals("#")) {
                slots += 2; // Non-null nodes add two slots
            }
        }
        
        return slots == 0; // All slots should be exactly filled
    }
}
