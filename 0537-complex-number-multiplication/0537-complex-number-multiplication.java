class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // Parse the first complex number
        int[] parts1 = parseComplex(num1);
        int real1 = parts1[0];
        int imaginary1 = parts1[1];
        
        // Parse the second complex number
        int[] parts2 = parseComplex(num2);
        int real2 = parts2[0];
        int imaginary2 = parts2[1];
        
        // Apply the multiplication formula
        int realPart = real1 * real2 - imaginary1 * imaginary2;
        int imaginaryPart = real1 * imaginary2 + imaginary1 * real2;
        
        // Return the result in the form "real+imaginaryi"
        return realPart + "+" + imaginaryPart + "i";
    }
    
    // Helper method to parse the complex number string
    private int[] parseComplex(String num) {
        // Split the string into real and imaginary parts
        String[] parts = num.split("\\+");
        int real = Integer.parseInt(parts[0]);
        int imaginary = Integer.parseInt(parts[1].replace("i", ""));
        return new int[]{real, imaginary};
    }
}
