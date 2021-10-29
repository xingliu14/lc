// https://leetcode.com/problems/word-break/
// DFS递归，但还需要一个Set来存已经走过的路，减少时间复杂度

class Solution {
    
    private Set<String> set = new HashSet<> ();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) {
            return true;
        }
        for(String str : wordDict) {
            if(s.indexOf(str) == 0) {
                String subString = s.substring(str.length());
                if(!set.contains(subString)) {
                    if(wordBreak(subString, wordDict)) {
                        return true;
                    } else {
                        set.add(subString);
                    }
                }
            }
        }
        return false;
    }
}