// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
// 直接转换比较即可

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return calculateNum(firstWord) + calculateNum(secondWord) == calculateNum(targetWord);
    }
    
    private int calculateNum(String str) {
        int i = 0, result = 0;
        while(i < str.length() && str.charAt(i) == 'a') {
            i++;
        }
        while(i < str.length()) {
            result = 10 * result + str.charAt(i) - 'a';
            i++;
        }
        return result;
    }
}