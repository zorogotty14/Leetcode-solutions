import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Map each email to its corresponding account index
        Map<String, Integer> emailToIndex = new HashMap<>();
        // Map each email to its corresponding name
        Map<String, String> emailToName = new HashMap<>();

        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        // Populate the mappings
        for (int i = 0; i < n; i++) {
            String name = accounts.get(i).get(0);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    uf.union(i, emailToIndex.get(email));
                }
                emailToName.put(email, name);
            }
        }

        // Group emails by their root parent
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int rootIndex = uf.find(emailToIndex.get(email));
            indexToEmails.computeIfAbsent(rootIndex, x -> new ArrayList<>()).add(email);
        }

        // Prepare the result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int index : indexToEmails.keySet()) {
            List<String> emails = indexToEmails.get(index);
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }

    // Union-Find helper class
    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}
