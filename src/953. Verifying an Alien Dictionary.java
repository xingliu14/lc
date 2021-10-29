// https://leetcode.com/problems/verifying-an-alien-dictionary/
// 需要想到只需要比较相邻的即可！

class Solution {
    public Map<Character, Integer> orderMap;
    
    public boolean isAlienSorted(String[] words, String order) {
        orderMap = new HashMap<> ();
        for(int i = 0; i < 26; i++) {
            orderMap.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++) {
            if(!compare(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean compare(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            if(i >= s2.length()) {
                return false;
            }
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            int o1 = orderMap.get(c1), o2 = orderMap.get(c2);
            if(o1 < o2) {
                return true;
            }
            if(o1 > o2) {
                return false;
            }
        }
        return true;
    }
}