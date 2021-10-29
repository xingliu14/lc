// https://leetcode.com/problems/process-tasks-using-servers/
// 直接模拟，特别注意的是time的处理，和每次要free的job，很关键！

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;
        int[] ans = new int[m];
        // Pair<finish_time, index_of_the_server>
        PriorityQueue<Pair<Integer, Integer>> currJobs = new PriorityQueue<> (
            (a, b) -> a.getKey() - b.getKey());
        // Pair<weight, index_of_the_server>
        PriorityQueue<Pair<Integer, Integer>> idleServers = new PriorityQueue<> (
            (a, b) -> a.getKey() - b.getKey() == 0 ? a.getValue() - b.getValue() : a.getKey() - b.getKey());
        
        for(int i = 0; i < n; i++) {
            idleServers.offer(new Pair<Integer, Integer> (servers[i], i));
        }
        
        int time = 0;
        for(int i = 0; i < m; i++) {
            time = Math.max(time, i);
            
            while(!currJobs.isEmpty() && currJobs.peek().getKey() <= time) {
                Pair<Integer, Integer> nextJob = currJobs.poll();
                idleServers.offer(new Pair<Integer, Integer> (servers[nextJob.getValue()], nextJob.getValue()));
            }
            
            while(idleServers.isEmpty()) {
                Pair<Integer, Integer> nextJob = currJobs.poll();
                time = nextJob.getKey();
                idleServers.offer(new Pair<Integer, Integer> (servers[nextJob.getValue()], nextJob.getValue()));
                while(!currJobs.isEmpty() && currJobs.peek().getKey() == time) {
                    Pair<Integer, Integer> moreJob = currJobs.poll();
                    idleServers.offer(new Pair<Integer, Integer> (servers[moreJob.getValue()], moreJob.getValue()));
                }
            }
            
            Pair<Integer, Integer> idleServer = idleServers.poll();
            ans[i] = idleServer.getValue();
            currJobs.offer(new Pair<Integer, Integer> (time + tasks[i], idleServer.getValue()));
        }
        
        return ans;
    }
}