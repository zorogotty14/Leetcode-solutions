class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            // Extract the age from the string (characters 11 and 12)
            int age = Integer.parseInt(detail.substring(11, 13));
            // Check if the age is greater than 60
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}