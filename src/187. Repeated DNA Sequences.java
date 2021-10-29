// https://leetcode.com/problems/repeated-dna-sequences/
// 我这是最蠢的做法。因为他总共只有4种字母，可以用四进制来表示，这样可以用一个数字来表示任意长度的string。

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> appear = new HashSet<> (), added = new HashSet<> ();
        List<String> result = new ArrayList<> ();
        if(s.length() < 11) {
            return result;
        }
        String curr = s.substring(0, 10);
        appear.add(curr);
        for(int i = 10; i < s.length(); i++) {
            curr = curr.substring(1) + s.charAt(i);
            if(appear.contains(curr) && !added.contains(curr)) {
                result.add(curr);
                added.add(curr);
            }
            appear.add(curr);
        }
        return result;
    }
}