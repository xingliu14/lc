// https://leetcode.com/problems/maximum-population-year/
// 简单

class Solution {
    public int maximumPopulation(int[][] logs) {
        int maxYear = 1950, currYear = 1950, max = 0, curr = 0;
        PriorityQueue<int[]> birthPq = new PriorityQueue<> ((a, b) -> a[0] - b[0]), deathPq = new PriorityQueue<> ((a,b) -> a[1] - b[1]);
        for(int[] log : logs) {
            birthPq.offer(log);
        }
        while(!birthPq.isEmpty()) {
            int[] temp = birthPq.poll();
            currYear = temp[0];
            while(!deathPq.isEmpty() && deathPq.peek()[1] <= currYear) {
                deathPq.poll();
            }
            deathPq.offer(temp);
            curr = deathPq.size();
            if(curr > max) {
                max = curr;
                maxYear = currYear;
            }
        }
        
        return maxYear;
    }
}