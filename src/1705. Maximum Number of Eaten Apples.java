// https://leetcode.com/problems/maximum-number-of-eaten-apples/
// 复习了一下Comparator和PriorityQueue，注意PQ优先取出最小的

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length, count = 0;
        
        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] apple1, int[] apple2){
                return apple1[0] - apple2[0];
            }
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<> (1, comp);
        for(int i = 0; i < n; i++) {
            pq.add(new int[]{days[i] + i - 1, apples[i]});
            while(!pq.isEmpty() && (pq.peek()[0] < i || pq.peek()[1] < 1)) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.peek()[1]--;
                count++;
            }
        }
                  
        while(!pq.isEmpty()) {
            while(!pq.isEmpty() && (pq.peek()[0] < n || pq.peek()[1] < 1)) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.peek()[1]--;
                count++;
            }
            n++;
        }
                  
        return count;
    }
}