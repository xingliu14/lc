// https://leetcode.com/problems/meeting-rooms-ii/
// 可以分别sort start和end，然后找最大的overlap。当然可能需要一些证明才行。

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length, max = 0;
        int[] start = new int[len], end = new int[len];
        for(int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int curr = 0;
        for(int i = 0; i < len; i++) {
            while(curr < len && start[curr] < end[i]) {
                max = Math.max(max, curr - i + 1);
                curr++;
            }
            if(curr == len) {
                return max;
            }
        }
        return max;
    }
}