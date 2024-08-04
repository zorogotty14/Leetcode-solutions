class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) {
            return triangle;
        }
        
        // Initialize the first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        // Generate each row
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> newRow = new ArrayList<>();
            
            newRow.add(1); // The first element is always 1
            
            // Compute the middle elements
            for (int j = 1; j < i; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            newRow.add(1); // The last element is always 1
            triangle.add(newRow);
        }
        
        return triangle;
    }
}