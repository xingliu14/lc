// https://leetcode.com/problems/jump-game-vii/
// 直接维护一个curr list即可

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) == '1') {
            return false;
        }
        List<Integer> curr = new LinkedList<> ();
        curr.add(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                while(!curr.isEmpty() && curr.get(0) + maxJump < i) {
                    curr.remove(0);
                }
                if(curr.isEmpty()) {
                    return false;
                }
                if(curr.get(0) + minJump <= i) {
                    curr.add(i);
                }
            }
        }
        return curr.get(curr.size() - 1) == s.length() - 1;
    }
}