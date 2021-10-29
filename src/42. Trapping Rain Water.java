// https://leetcode.com/problems/trapping-rain-water/
// 这个解法太难想了，用stack找每一个盆地，他是一横排一横排加起来的

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int rain = 0;
        Stack<Integer> stack = new Stack<> ();
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curr = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                rain += (Math.min(height[i], height[stack.peek()]) - height[curr]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return rain;
    }
}