import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> uniqueSignatures = new HashSet<>();

        for (String word : words) {
            String even = "", odd = "";

            // Separate even and odd indexed characters
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even += word.charAt(i);
                } else {
                    odd += word.charAt(i);
                }
            }

            // Sort the even and odd character groups
            char[] evenChars = even.toCharArray();
            char[] oddChars = odd.toCharArray();
            Arrays.sort(evenChars);
            Arrays.sort(oddChars);

            // Combine the sorted even and odd groups to create a unique signature
            String signature = new String(evenChars) + new String(oddChars);

            // Add the signature to the set
            uniqueSignatures.add(signature);
        }

        // The number of unique signatures is the number of groups
        return uniqueSignatures.size();
    }
}
