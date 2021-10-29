// https://leetcode.com/problems/count-and-say/
//使用递归，然后一段一段append

class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char curr = '0';
        for(char temp : last.toCharArray()) {
            if(count != 0 && temp != curr) {
                sb.append(count);
                sb.append(curr);
                count = 1;
                curr = temp;
            } else {
                curr = temp;
                count += 1;
            }
        }
        sb.append(count);
        sb.append(curr);
        return sb.toString();
    }
}