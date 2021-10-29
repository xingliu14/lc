// https://leetcode.com/problems/multiply-strings/
// 模拟手算乘法，最后还要注意一下是不是0

class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                temp += result[i + j + 1] + 10 * result[i + j];
                result[i + j + 1] = temp % 10;
                result[i + j] = temp / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len1 + len2; i++) {
            if(sb.length() != 0 || result[i] != 0) {
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}