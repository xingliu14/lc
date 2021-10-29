// https://leetcode.com/problems/shortest-word-distance/
// one pass 直接比较

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE, index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                index1 = i;
                min = Math.min(min, Math.abs(index2 - index1));
            } else if(wordsDict[i].equals(word2)) {
                index2 = i;
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        
        return min;
    }
}