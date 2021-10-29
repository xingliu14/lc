// https://leetcode.com/problems/group-anagrams/
// 主要就是怎么把anagram集合起来，可以用string，也可以用int或者其他的

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<> ();
        }
        
        Map<String, List<String>> map = new HashMap<> ();
        int[] count = new int[26];
        
        for(String str : strs) {
            Arrays.fill(count, 0);
            for(char c : str.toCharArray()) {
                count[c - 'a'] += 1;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i : count) {
                sb.append("@");
                sb.append(i);
            }
            String temp = sb.toString();
            
            if(map.containsKey(temp)) {
                map.get(temp).add(str);
            } else {
                List<String> newList = new ArrayList<> ();
                newList.add(str);
                map.put(temp, newList);
            }
        }
        
        return new ArrayList<> (map.values());
    }
}