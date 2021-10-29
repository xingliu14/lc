// https://leetcode.com/problems/minimum-knight-moves/
//非常神奇的dp，基本问题的设置很tricky

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Integer> memo = new HashMap<>();
        return helper(x, y, memo);
    }

    private int helper(int x, int y, Map<String, Integer> memo) {
        String key = x + ":" + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        int min = Math.min(helper(Math.abs(x - 1), Math.abs(y - 2), memo), 
                           helper(Math.abs(x - 2), Math.abs(y - 1), memo)) + 1;
        memo.put(key, min);
        return min;
    }
}