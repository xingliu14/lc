// https://leetcode.com/problems/strobogrammatic-number/
// 傻逼题

class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = Map.of(
            '1', '1',
            '6', '9',
            '8', '8',
            '9', '6',
            '0', '0'
        );
        
        int head = 0, tail = num.length() - 1;
        while(head <= tail) {
            char c = num.charAt(head);
            if(!map.containsKey(c)) {
                return false;
            }
            if(map.get(c) != num.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        
        return true;
    }
}