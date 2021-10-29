// https://leetcode.com/problems/permutation-sequence/
// 果然这种排列问题可以用数学计算直接得到顺序

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> left = new ArrayList<> ();
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            left.add(i);
            fact *= i;
        }
        k -= 1;
        while(sb.length() != n) {
            fact /= n - sb.length();
            int curr = k  / fact;
            sb.append(left.get(curr));
            left.remove(curr);
            k %= fact;
        }
        return sb.toString();
    }
}