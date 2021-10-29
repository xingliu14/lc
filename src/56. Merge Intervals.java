// https://leetcode.com/problems/merge-intervals/
// 最关键的是先按照第一个数排序，再依次合并

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null ||  intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> curr = new ArrayList<> ();
        curr.add(intervals[0][0]);
        curr.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= curr.get(curr.size() - 1)) {
                curr.set(curr.size() - 1, Math.max(curr.get(curr.size() - 1), intervals[i][1]));
            } else {
                curr.add(intervals[i][0]);
                curr.add(intervals[i][1]);
            }
        }
        int[][] result = new int[curr.size() / 2][2];
        for(int i = 0; i < curr.size() / 2; i++) {
            result[i][0] = curr.get(i * 2);
            result[i][1] = curr.get(i * 2 + 1);
        }
        return result;
    }
}