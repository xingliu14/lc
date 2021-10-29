// https://leetcode.com/problems/strobogrammatic-number-ii/
// 因为0的存在，我必须用backtrack而不能用递归，然后因为增加元素的操作，返回一个值比较方便

class Solution {
    private Map<Character, Character> map = Map.of(
            '1', '1',
            '6', '9',
            '0', '0',
            '8', '8',
            '9', '6'
    );
    
    public List<String> findStrobogrammatic(int n) {
        List<String> temp = new ArrayList<> ();
        if(n % 2 == 0) {
            temp.add("");
        }
        if(n % 2 == 1) {
            temp.add("0");
            temp.add("1");
            temp.add("8");
        }
        
        return backtrack(temp, n % 2, n);
    }
    
    private List<String> backtrack(List<String> temp, int curr_len, int n) {
        if(curr_len == n) {
            return temp;
        }
        List<String> newTemp = new ArrayList<> ();
        for(String str : temp) {
            for(char c : map.keySet()) {
                if(c != '0' || curr_len + 2 != n) {
                    newTemp.add(c + str + map.get(c));
                }
            }
        }
        return backtrack(newTemp, curr_len + 2, n);
    }
}