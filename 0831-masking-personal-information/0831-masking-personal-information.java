class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }

    private String maskEmail(String email) {
        String[] parts = email.split("@");
        String name = parts[0].toLowerCase();
        String domain = parts[1].toLowerCase();
        // Mask the name: keep the first and last letters, replace the rest with "*****"
        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
    }

    private String maskPhone(String phone) {
        // Remove all non-digit characters
        String digits = phone.replaceAll("[^0-9]", "");
        int localNumberLength = 10;
        int countryCodeLength = digits.length() - localNumberLength;

        // Mask the local number
        String localNumber = "***-***-" + digits.substring(digits.length() - 4);

        // Add country code mask if necessary
        if (countryCodeLength == 0) {
            return localNumber;
        } else {
            StringBuilder countryCode = new StringBuilder("+");
            for (int i = 0; i < countryCodeLength; i++) {
                countryCode.append("*");
            }
            return countryCode + "-" + localNumber;
        }
    }
}
