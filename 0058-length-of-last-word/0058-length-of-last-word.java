class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        String lastWord = words[words.length - 1];
        return lastWord.length();
    }
}