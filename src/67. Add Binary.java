// https://leetcode.com/problems/add-binary/
// 一位一位加即可

class Solution {
    public String addBinary(String a, String b) {
        int len_a = a.length() - 1, len_b = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0;
        while(len_a >= 0 || len_b >= 0) {
            sum = 0;
            if(len_a >= 0) {
                sum += a.charAt(len_a--) - '0';
            }
            if(len_b >= 0) {
                sum += b.charAt(len_b--) - '0';
            }
            sum += carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}