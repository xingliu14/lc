// https://leetcode.com/problems/reorganize-string/
// PriorityQueue真他妈好用

class Solution {
    class pair {
        char c;
        int count;
        public pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<> ();
        PriorityQueue<pair> pq = new PriorityQueue<> (
            (a, b) -> b.count - a.count);
        for(char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            pair curr = pq.poll();
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != curr.c) {
                sb.append(curr.c);
                curr.count--;
            } else if(pq.isEmpty()) {
                return "";
            } else {
                pair next = pq.poll();
                sb.append(next.c);
                next.count--;
                if(next.count != 0) {
                    pq.offer(next);
                }
            }
            if(curr.count != 0) {
                pq.offer(curr);
            }
        }
        return sb.toString();
    }
}