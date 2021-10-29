// https://leetcode.com/problems/count-vowels-permutation/
// 最麻烦其实就是1000000007的处理

class Solution {
    public int countVowelPermutation(int n) {
        if(n == 1) {
            return 5;
        }
        long[] num = {1, 1, 1, 1, 1};
        while(n > 1) {
            long[] temp = new long[5];
            temp[0] = (num[1] + num[2] + num[4]) % 1000000007;
            temp[1] = (num[0] + num[2]) % 1000000007;
            temp[2] = (num[1] + num[3]) % 1000000007;
            temp[3] = (num[2]) % 1000000007;
            temp[4] = (num[2] + num[3]) % 1000000007;
            num = temp;
            n--;
        }
        return (int) ((num[0] % 1000000007 + num[1] % 1000000007 + num[2] % 1000000007 + num[3] % 1000000007 + num[4] % 1000000007) % 1000000007);
    }
}