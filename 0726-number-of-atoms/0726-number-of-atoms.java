class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        int i = 0;
        
        while (i < n) {
            char ch = formula.charAt(i);
            
            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                i++;
                int start = i;
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > start) {
                    count = Integer.parseInt(formula.substring(start, i));
                } else {
                    count = 1;
                }
                Map<String, Integer> top = stack.pop();
                Map<String, Integer> map = stack.peek();
                for (String key : top.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + top.get(key) * count);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                Map<String, Integer> map = stack.peek();
                map.put(name, map.getOrDefault(name, 0) + count);
            }
        }
        
        Map<String, Integer> map = stack.pop();
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        for (String key : keys) {
            sb.append(key);
            int count = map.get(key);
            if (count > 1) {
                sb.append(count);
            }
        }
        
        return sb.toString();
    }
}