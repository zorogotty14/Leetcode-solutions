class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;
            
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - totalChars) / diff;
                int r = (maxWidth - totalChars) % diff;
                
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        
        return result;
    }
}