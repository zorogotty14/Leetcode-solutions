class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder bin = new StringBuilder();
        while (head != null) {
            bin.append(head.val);
            head = head.next;
        }

        int power = bin.length() - 1;
        int result = 0;

        for (int i = 0; i < bin.length(); i++) {
            result += (bin.charAt(i) - '0') * Math.pow(2, power);
            power--;
        }

        return result;
    }
}