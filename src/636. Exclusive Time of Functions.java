// https://leetcode.com/problems/exclusive-time-of-functions/
// 直接用stack，在start的情况下还需要判断一下stack是不是空。

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        ArrayDeque<Integer> stack = new ArrayDeque<> ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while(i < logs.size()) {
            s = logs.get(i).split(":");
            if(s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
}