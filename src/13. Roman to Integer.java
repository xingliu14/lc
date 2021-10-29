// https://leetcode.com/problems/roman-to-integer/
// 要注意是的减去的两字组合可能出现不止一次

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        for(Character c : s.toCharArray()) {
            result += map.get(c);
        }
        result -= (findSubstringCount(s, "CM") + findSubstringCount(s, "CD")) * 200 +
                    (findSubstringCount(s, "XC") + findSubstringCount(s, "XL")) * 20 +
                    (findSubstringCount(s, "IX") + findSubstringCount(s, "IV")) * 2;
        return result;
    }
    
    private int findSubstringCount(String str, String subStr) {
        int count = 0, lastIndex = 0;
        while(lastIndex != -1) {
            lastIndex = str.indexOf(subStr, lastIndex);
            if(lastIndex != -1) {
                lastIndex += 1;
                count ++;
            }
        }
        return count;
    }
}