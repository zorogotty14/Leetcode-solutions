class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Create a set for quick lookup of supplies.
        Set<String> supplySet = new HashSet<>();
        for (String s : supplies) {
            supplySet.add(s);
        }
        
        // Graph: map from ingredient -> list of recipes that depend on that ingredient.
        Map<String, List<String>> graph = new HashMap<>();
        // Indegree: count how many ingredients (dependencies) each recipe still needs.
        Map<String, Integer> indegree = new HashMap<>();
        
        // Initialize indegree for every recipe to 0.
        for (String recipe : recipes) {
            indegree.put(recipe, 0);
        }
        
        // Build the graph and indegree.
        // For each recipe, for each ingredient it needs, if the ingredient is not in supplies,
        // then it contributes to a dependency.
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ing : ingredients.get(i)) {
                if (!supplySet.contains(ing)) {
                    graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
                    indegree.put(recipe, indegree.get(recipe) + 1);
                }
            }
        }
        
        // Use a queue to perform BFS on available items (ingredients or recipes).
        Queue<String> queue = new LinkedList<>();
        
        // Add all supplies to the queue.
        for (String s : supplies) {
            queue.offer(s);
        }
        
        // Also add recipes that have no dependencies (all ingredients available from supplies).
        List<String> result = new ArrayList<>();
        for (String recipe : recipes) {
            if (indegree.get(recipe) == 0) {
                queue.offer(recipe);
                result.add(recipe);
            }
        }
        
        // Process the graph.
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (graph.containsKey(curr)) {
                for (String rec : graph.get(curr)) {
                    indegree.put(rec, indegree.get(rec) - 1);
                    if (indegree.get(rec) == 0) {
                        queue.offer(rec);
                        result.add(rec);
                    }
                }
            }
        }
        
        return result;
    }
}
