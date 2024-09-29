import java.util.Random;

class Solution {

    private double radius;
    private double x_center;
    private double y_center;
    private Random random;

    // Constructor to initialize the circle properties
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new Random();
    }
    
    // Method to generate a random point inside the circle
    public double[] randPoint() {
        // Generate a random radius (use sqrt to ensure uniform distribution)
        double r = Math.sqrt(random.nextDouble()) * radius;
        // Generate a random angle between 0 and 2π
        double theta = random.nextDouble() * 2 * Math.PI;
        // Convert polar coordinates to Cartesian coordinates
        double x = x_center + r * Math.cos(theta);
        double y = y_center + r * Math.sin(theta);
        // Return the generated point as an array
        return new double[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
