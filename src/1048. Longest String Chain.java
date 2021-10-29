// https://leetcode.com/problems/longest-string-chain/
// 就强行搞，需要两个辅助方程还有点麻烦

class Solution {
    private Map<String, List<String>> map;
    private Map<String, Integer> count;
    
    public int longestStrChain(String[] words) {
        map = new HashMap<> ();
        for(String word1 : words) {
            for(String word2 : words) {
                if(word1.length() < word2.length() && check(word1, word2)) {
                    List<String> tempList = map.getOrDefault(word1, new ArrayList<> ());
                    tempList.add(word2);
                    map.put(word1, tempList);
                }
            }
        }
        count = new HashMap<> ();
        int max = 1;
        for(String word : map.keySet()) {
            max = Math.max(max, dfs(word));
        }
        return max;
    }
    
    private int dfs(String str) {
        if(count.containsKey(str)) {
            return count.get(str);
        }
        List<String> list = map.getOrDefault(str, new ArrayList<> ());
        int max = 0;
        for(String nextStr : list) {
            max = Math.max(max, dfs(nextStr));
        }
        count.put(str, 1 + max);
        return 1 + max;
    }
    
    private boolean check(String str1, String str2) {
        if(str1.length() + 1 != str2.length()) {
            return false;
        }
        int offset = 0;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i + offset)) {
                if(offset == 0) {
                    offset = 1;
                    i--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}