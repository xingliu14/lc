// https://leetcode.com/problems/interleaving-string/
// 对于这种需要存档，走一步算一步的题。就要想到用stack，因为有些地方可能走1或者2都可以。我们默认先走1，然后存档。这里就要用到twoGoFirst这个flag。这道题很好！

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }
        Deque<int[]> stack = new ArrayDeque<> ();
        int index1 = 0, index2 = 0;
        boolean twoGoFirst = false;
        while(index1 < s1.length() || index2 < s2.length()) {
            if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2) && !twoGoFirst) {
                if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2)) {
                    int[] checkPoint = {index1, index2};
                    stack.push(checkPoint);
                }
                index1 += 1;
            } else if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2)) {
                index2 += 1;
                twoGoFirst = false;
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    int[] lastCheckPoint = stack.pop();
                    index1 = lastCheckPoint[0];
                    index2 = lastCheckPoint[1];
                    twoGoFirst = true;
                }
            }
        }
        return index1 == s1.length() && index2 == s2.length();
    }
}
