import java.util.*;

class ProductOfNumbers {
    private List<Integer> cumulative;
    
    public ProductOfNumbers() {
        cumulative = new ArrayList<>();
        // Initialize with a neutral product value of 1
        cumulative.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            // A zero resets the cumulative product history.
            cumulative.clear();
            cumulative.add(1);
        } else {
            // Multiply the last cumulative product with the new number.
            int lastProduct = cumulative.get(cumulative.size() - 1);
            cumulative.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int n = cumulative.size() - 1; // number of actual elements added since last reset.
        if (k > n) {
            // This means there's a zero within the last k numbers.
            return 0;
        }
        // Otherwise, the product of the last k numbers is:
        // cumulative[n] / cumulative[n - k]
        return cumulative.get(n) / cumulative.get(n - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
