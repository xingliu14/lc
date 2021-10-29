// https://leetcode.com/problems/partition-labels/
// 这个方法看上去很麻烦，但复杂度其实也是O(n) &O（1）。还可以只记最后的位置，然后如果碰上了就算一个

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<> ();
        Map<Character, List<Integer>> map = new HashMap<> ();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            List<Integer> index = map.getOrDefault(c, new ArrayList<> ());
            if(index.size() < 2) {
                index.add(i);
            } else {
                index.set(1, i);
            }
            map.put(c, index);
        }
        Comparator<List<Integer>> comp = new Comparator<> () {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                return l1.get(0) - l2.get(0);
            }
        };
        PriorityQueue<List<Integer>> pq = new PriorityQueue<> (comp);
        for(List<Integer> index : map.values()) {
            if(index.size() == 2) {
                pq.offer(index);
            }
            if(index.size() == 1) {
                index.add(index.get(0));
                pq.offer(index);
            }
        }
        List<Integer> indexes = new ArrayList<> ();
        while(!pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            if(indexes.size() > 0 && curr.get(0) < indexes.get(indexes.size() - 1)) {
                indexes.set(indexes.size() - 1, Math.max(indexes.get(indexes.size() - 1), curr.get(1)));
            } else {
                indexes.add(curr.get(0));
                indexes.add(curr.get(1));
            }
        }
        for(int i = 0; i < indexes.size() / 2; i++) {
            result.add(indexes.get(2 * i + 1) - indexes.get(2 * i) + 1);
        }
        return result;
    }
}