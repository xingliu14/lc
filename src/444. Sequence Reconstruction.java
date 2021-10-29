// https://leetcode.com/problems/sequence-reconstruction/
// 首先要想到unique的两个条件：1.每一个seq合法，2.每一个org的相邻均有对应。然后注意里面的corner case很多

class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(seqs.size() == 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new HashMap<> ();
        Set<Integer> set = new HashSet<> ();
        for(int i = 0; i < org.length; i++) {
            map.put(org[i], i);
        }
        
        for(List<Integer> seq : seqs) {
            if(!map.containsKey(seq.get(0))) {
                return false;
            }
            for(int i = 1; i < seq.size(); i++) {
                if(!map.containsKey(seq.get(i)) || !map.containsKey(seq.get(i - 1)) || map.get(seq.get(i)) <= map.get(seq.get(i - 1))) {
                    return false;
                }
                if(map.get(seq.get(i)) == map.get(seq.get(i - 1)) + 1) {
                    set.add(seq.get(i));
                }
            }
        }
        
        return set.size() == org.length - 1;
    }
}