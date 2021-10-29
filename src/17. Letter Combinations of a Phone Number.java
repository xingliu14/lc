// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// backtrack

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<> ();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, List<Character>> map = Map.of(
            '2', Arrays.asList('a', 'b', 'c'),
            '3', Arrays.asList('d', 'e', 'f'),
            '4', Arrays.asList('g', 'h', 'i'),
            '5', Arrays.asList('j', 'k', 'l'),
            '6', Arrays.asList('m', 'n', 'o'),
            '7', Arrays.asList('p', 'q', 'r', 's'),
            '8', Arrays.asList('t', 'u', 'v'),
            '9', Arrays.asList('w', 'x', 'y', 'z'));
        helper(result, digits, 0, new StringBuffer(), map);
        return result;
    }
    
    private void helper(List<String> result, String digits, int start, StringBuffer sb, Map<Character, List<Character>> map) {
        if(start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for(char c : map.get(digits.charAt(start))) {
            sb.append(c);
            helper(result, digits, start + 1, sb, map);
            sb.setLength(sb.length() - 1);
        }
        return;
    }
}