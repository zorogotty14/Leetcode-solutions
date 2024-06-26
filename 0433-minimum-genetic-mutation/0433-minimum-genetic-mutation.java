class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        char[] genes = new char[] {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) {
                    return mutations;
                }
                
                char[] currentArray = current.toCharArray();
                for (int j = 0; j < currentArray.length; j++) {
                    char oldChar = currentArray[j];
                    for (char gene : genes) {
                        currentArray[j] = gene;
                        String next = new String(currentArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    currentArray[j] = oldChar;
                }
            }
            mutations++;
        }
        
        return -1;
    }
}