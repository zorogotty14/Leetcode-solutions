class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<>());
    }
    
    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                List<String> suffixWays = wordBreakHelper(suffix, wordDict, memo);
                
                for (String way : suffixWays) {
                    String space = way.isEmpty() ? "" : " ";
                    result.add(word + space + way);
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}