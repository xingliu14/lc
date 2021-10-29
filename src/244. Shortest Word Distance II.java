// https://leetcode.com/problems/shortest-word-distance-ii/
// 用Map存位置，然后直接遍历两个位置list

class WordDistance {
    
    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<> ();
        for(int i = 0; i < wordsDict.length; i++) {
            List<Integer> list = map.getOrDefault(wordsDict[i], new ArrayList<> ());
            list.add(i);
            map.put(wordsDict[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE, index1 = 0, index2 = 0;
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        while(index1 < list1.size() && index2 < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(index1) - list2.get(index2)));
            if(list1.get(index1) < list2.get(index2)) {
                index1++;
            } else {
                index2++;
            }
        }
        return min;
    }
}