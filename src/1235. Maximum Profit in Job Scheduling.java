// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// 这道题把数据结构用得飞起。先按照结束时间排序，因为dp的key是结束时间。然后用TreeMap的floorEntry直接二分找需要的值，比较一下，不更新的话啥都不用干。特别厉害！

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b)->a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue()) {
                dp.put(job[1], cur);
            }
        }
        return dp.lastEntry().getValue();
    }
}