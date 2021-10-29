// https://leetcode.com/problems/word-ladder/
// 需要一个list来存现在这一层，再用一个set来存访问到了哪些。注意他这道题的设置的各种坑。

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<> ();
        List<String> curr = new ArrayList<> ();
        visited.add(beginWord);
        curr.add(beginWord);
        int count = 1;
        while(!curr.isEmpty()) {
            count++;
            List<String> next = new ArrayList<> ();
            for(String pathWord : curr) {
                for(String s : wordList) {
                    if(!visited.contains(s) && isAdjacent(pathWord, s)) {
                        if(s.equals(endWord)) {
                            return count;
                        }
                        next.add(s);
                        visited.add(s);
                    }
                }
            }
            curr = next;
        }
        return 0;
    }
    
    private boolean isAdjacent(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(count == 0) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        return count == 1;
    }
}