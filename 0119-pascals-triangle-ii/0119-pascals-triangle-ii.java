class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // Initial row [1]
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>(i + 1);
            newRow.add(1); // The first element is always 1
            
            // Fill in the middle elements
            for (int j = 1; j < i; j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            
            newRow.add(1); // The last element is always 1
            row = newRow;
        }
        
        return row;
    }
}