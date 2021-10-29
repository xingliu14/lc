// https://leetcode.com/problems/insert-interval/
// 这道题其实和前一道题基本一样，只不过加了一个if-else来判断什么时候加额外的那个interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals == null || intervals.length == 0) {
            int[][] result =  new int[1][2];
            result[0] = newInterval;
            return result;
        }
        
        List<Integer> curr = new ArrayList<> ();
        boolean merged = false;
        
        for(int i = 0; i < intervals.length; i++) {
            if(!merged && newInterval[0] < intervals[i][0]) {
               insertNewInterval(curr, newInterval);
                merged = true;
                i -= 1;
            } else {
                insertNewInterval(curr, intervals[i]);
            }
        }
        
        if(!merged) {
            insertNewInterval(curr, newInterval);
        }
        
        int[][] result = new int[curr.size() / 2][2];
        for(int i = 0; i < curr.size() / 2; i++) {
            result[i][0] = curr.get(i * 2);
            result[i][1] = curr.get(i * 2 + 1);
        }
        
        return result;
    }
    
    private void insertNewInterval(List<Integer> list, int[] newInterval) {
        if(list.size() == 0) {
            list.add(newInterval[0]);
            list.add(newInterval[1]);
        } else {
            if(newInterval[0] <= list.get(list.size() - 1)) {
                list.set(list.size() - 1, Math.max(list.get(list.size() - 1), newInterval[1]));
            } else {
                list.add(newInterval[0]);
                list.add(newInterval[1]);
            }
        }
        return;
    }
}