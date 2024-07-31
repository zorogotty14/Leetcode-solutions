class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(result, new StringBuilder(), s, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentIp, String s, int index, int segment) {
        if (segment == 4 && index == s.length()) {
            result.add(currentIp.toString());
            return;
        }

        if (segment == 4 || index == s.length()) {
            return;
        }

        int length = currentIp.length();
        if (segment > 0) {
            currentIp.append('.');
        }

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (isValidPart(part)) {
                currentIp.append(part);
                backtrack(result, currentIp, s, index + i, segment + 1);
                currentIp.setLength(length + (segment > 0 ? 1 : 0));
            }
        }
    }

    private boolean isValidPart(String part) {
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }
}