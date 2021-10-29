// https://leetcode.com/problems/daily-temperatures/
// 从后往前考虑的话，如果后面的比现在的小，那我就可以直接pop掉了，所以可以简单的用stack

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<> ();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}