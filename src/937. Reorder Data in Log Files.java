// https://leetcode.com/problems/reorder-data-in-log-files/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<> () {
            @Override
            public int compare(String s1, String s2) {
                return s2.substring(s2.indexOf(' ') + 1).compareTo(s1.substring(s1.indexOf(' ') + 1)) != 0 ?
                    s2.substring(s2.indexOf(' ') + 1).compareTo(s1.substring(s1.indexOf(' ') + 1)) :
                    s2.substring(0, s2.indexOf(' ')).compareTo(s1.substring(0, s1.indexOf(' ')));
            }
        };
        PriorityQueue<String> pq = new PriorityQueue<> (comp);
        String[] result = new String[logs.length];
        int index = logs.length - 1;
        for(int i = logs.length - 1; i >= 0; i--) {
            if(Character.isDigit(logs[i].split(" ", 2)[1].charAt(0))) {
                result[index--] = logs[i];
            } else {
                pq.offer(logs[i]);
            }
        }
        while(!pq.isEmpty()) {
            result[pq.size() - 1] = pq.poll();
        }
        return result;
    }
}