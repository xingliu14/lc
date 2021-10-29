// https://leetcode.com/problems/task-scheduler/
// 要想到最大的限制就是最多的任务，然后我们只需要再算出来idle的次数即可！

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> tempMap = new HashMap<> ();
        PriorityQueue<Integer> remain = new PriorityQueue<> (
            (a, b) -> b - a) ;
        for(char c : tasks) {
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
        }
        for(Integer value : tempMap.values()) {
            remain.offer(value);
        }
        
        int max = remain.poll();
        int idle = (max - 1) * n;
        while(!remain.isEmpty()) {
            int num = remain.poll();
            if(num == max) {
                idle++;
            }
            idle = idle - num < 0 ? 0 : idle - num;
        }
        return tasks.length + idle;
    }
}