// https://leetcode.com/problems/longest-repeating-character-replacement/
// 答案里很多sliding window都错的，需要两个数据结构来找最大值。

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<> ();
        TreeMap<Integer, Set<Character>> treeMap = new TreeMap<> ();
        int left = 0, max = 0;
        
        for(int right = 0; right < s.length(); right++) {
            int newFreq = freqMap.getOrDefault(s.charAt(right), 0) + 1;
            freqMap.put(s.charAt(right), newFreq);
            
            Set<Character> set = treeMap.getOrDefault(newFreq, new HashSet<> ());
            set.add(s.charAt(right));
            treeMap.put(newFreq, set);
            if(newFreq != 1) {
                treeMap.get(newFreq - 1).remove(s.charAt(right));
            }
            
            while(right - left + 1 - treeMap.lastKey() > k) {
                int leftFreq = freqMap.get(s.charAt(left));
                freqMap.put(s.charAt(left), leftFreq - 1);
                Set<Character> set2 = treeMap.getOrDefault(leftFreq - 1, new HashSet<> ());
                set2.add(s.charAt(left));
                treeMap.put(leftFreq - 1, set2);
                treeMap.get(leftFreq).remove(s.charAt(left));
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}