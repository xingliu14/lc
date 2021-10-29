// https://leetcode.com/problems/excel-sheet-column-title/
// 注意因为其实他是从1-26计数的，所以每次要先减去1才行

class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int curr = (n - 1) % 26;
            sb.append((char)('A' + curr));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}