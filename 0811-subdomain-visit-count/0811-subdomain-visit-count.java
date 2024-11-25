import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        // Map to store domain counts
        Map<String, Integer> domainCounts = new HashMap<>();

        // Process each count-paired domain
        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            // Split domain into subdomains
            String[] subdomains = domain.split("\\.");
            String currentDomain = "";

            // Traverse subdomains from the lowest level to the highest level
            for (int i = subdomains.length - 1; i >= 0; i--) {
                currentDomain = subdomains[i] + (currentDomain.isEmpty() ? "" : ".") + currentDomain;
                domainCounts.put(currentDomain, domainCounts.getOrDefault(currentDomain, 0) + count);
            }
        }

        // Prepare the result list
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCounts.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
