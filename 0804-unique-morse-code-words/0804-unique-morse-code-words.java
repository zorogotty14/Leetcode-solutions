import java.util.HashSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        // Morse code representations for each letter
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                              "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                              "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> uniqueTransformations = new HashSet<>();

        // Transform each word into Morse code and add to the set
        for (String word : words) {
            StringBuilder transformation = new StringBuilder();
            for (char c : word.toCharArray()) {
                transformation.append(morseCode[c - 'a']);
            }
            uniqueTransformations.add(transformation.toString());
        }

        // Return the number of unique transformations
        return uniqueTransformations.size();
    }
}
