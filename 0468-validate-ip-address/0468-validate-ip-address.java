class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }
    
    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) {
                return false;
            }
            
            // Check if it's purely a number
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            
            int num = Integer.parseInt(part);
            // Check range 0-255 and no leading zeros
            if (num < 0 || num > 255 || (part.length() > 1 && part.charAt(0) == '0')) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) {
            return false;
        }
        
        String hexDigits = "0123456789abcdefABCDEF";
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) {
                return false;
            }
            
            for (char c : part.toCharArray()) {
                if (hexDigits.indexOf(c) == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
