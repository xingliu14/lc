// https://leetcode.com/problems/strobogrammatic-number-iii/
// 死亡结构化编程

class Solution {
    private Map<Character, Character> map = Map.of(
            '1', '1',
            '6', '9',
            '0', '0',
            '8', '8',
            '9', '6'
    );
    
    public int strobogrammaticInRange(String low, String high) {
        int result = 0;
        List<String> odd = new ArrayList<> (List.of("1", "0", "8")), even = new ArrayList<> (List.of(""));
        for(int i = 1; i <= high.length(); i++) {
            if(i % 2 == 0) {
                even = extend(even);
                result += countValid(low, high, i, even);
            } else {
                if(i != 1) {
                    odd = extend(odd);
                }
                result += countValid(low, high, i, odd);
            }
        }
        
        return result;
    }
    
    private List<String> extend(List<String> prev) {
        List<String> result = new ArrayList<> ();
        for(String str : prev) {
            for(char c : map.keySet()) {
                result.add(c + str + map.get(c));
            }
        }
        return result;
    }
    
    private int countValid(String low, String high, int len, List<String> list) {
        int result = 0;
        if(len < low.length()) {
            return 0;
        }
        if(low.length() == high.length()) {
            for(String str : list) {
                if(str.compareTo(low) >= 0 && str.compareTo(high) <= 0) {
                    result++;
                }
            }
            return result;
        }
        if(len == low.length()) {
            for(String str : list) {
                if(str.compareTo(low) >= 0) {
                    result++;
                }
            }
        } else if(len == high.length()) {
            for(String str : list) {
                if(str.compareTo(high) <= 0 && (len == 1 || str.charAt(0) != '0')) {
                    result++;
                }
            }
        } else {
            result = (int) (list.size() * 0.8);
        }
        
        return result;
    }
}