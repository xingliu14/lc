// https://leetcode.com/problems/robot-bounded-in-circle/
// 只需要判断是否能方向正确地回到原点。注意switch的用法，一定要用break！

class Solution {
    public boolean isRobotBounded(String instructions) {
        int d = 0, x = 0, y = 0;
        do {
            for(char c : instructions.toCharArray()) {
                switch(c) {
                    case 'G':
                        x += (d % 2) * -(d - 2);
                        y += ((d % 2) - 1) * (d - 1);
                        break;
                    case 'L':
                        d = (d + 3) % 4;
                        break;
                    case 'R':
                        d = (d + 1) % 4;
                        break;
                }
            }
        } while(d != 0);
        return x == 0 && y == 0;
    }
}