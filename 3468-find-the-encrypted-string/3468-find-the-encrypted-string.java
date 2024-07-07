class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        int shift = k % n;  // Calculate effective shift
        StringBuilder encrypted = new StringBuilder(n);
        
        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            encrypted.append(s.charAt(newIndex));
        }
        
        return encrypted.toString();
    }
}