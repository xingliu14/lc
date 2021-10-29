// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
// 各种循环，一位一位的移动。注意到了队尾，需要只把第一个删掉然后继续。

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<> (), curr = new ArrayList<> ();
        Set<Integer> existing = new HashSet<> ();
        
        if(words == null || words.length == 0) {
            return result;
        }
        
        int len = words[0].length();
        
        for(int i = 0; i < len; i++) {
            curr.clear();
            existing.clear();
            for(int j = 0; i + len * (j + words.length - curr.size()) <= s.length(); j++) {
                for(int k = 0; k < words.length; k++) {
                    if(!existing.contains(k) && words[k].equals(s.substring(i + len * j, i + len * (1 + j)))) {
                        existing.add(k);
                        curr.add(k);
                        if(curr.size() == words.length) {
                            result.add(i + len * (j - words.length + 1));
                            int first = curr.get(0);
                            curr.remove(0);
                            existing.remove(first);
                        }
                        break;
                    }
                    if(k == words.length - 1) {
                        if(!curr.isEmpty()) {
                            j -= 1;
                            int first = curr.get(0);
                            curr.remove(0);
                            existing.remove(first);
                        }
                        else {
                            curr.clear();
                            existing.clear();
                        }
                    }
                }
            }
        }
        
        return result;
    }
}