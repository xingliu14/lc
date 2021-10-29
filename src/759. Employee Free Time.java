// https://leetcode.com/problems/employee-free-time/
// 把每个Inteval一视同仁找空间即可

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<> (
            (i1, i2) -> i1.start - i2.start);
        
        for(List<Interval> list : schedule) {
            for(Interval i : list) {
                pq.offer(i);
            }
        }
        
        int start = -1;
        List<Interval> result = new ArrayList<> ();
        while(!pq.isEmpty()) {
            Interval curr = pq.poll();
            if(start != -1 && start < curr.start) {
                Interval temp = new Interval(start, curr.start);
                result.add(temp);
            }
            start = Math.max(start, curr.end);
        }
        
        return result;
    }
}