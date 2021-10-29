// https://leetcode.com/problems/largest-number/
// PriorityQueue的典型用法

class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> comp = new Comparator<> () {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        };
        
        PriorityQueue<String> pq = new PriorityQueue<> (comp);
        for(int num : nums) {
            pq.offer(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}