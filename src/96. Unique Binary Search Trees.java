// https://leetcode.com/problems/unique-binary-search-trees/
// divide & conqure 递归即可

class Solution {
    public int numTrees(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int result = 0;
        for(int i = 1; i <= n; i++) {
            int left = Math.max(i - 1, 1);
            int right = Math.max(n - i, 1);
            result += numTrees(left) * numTrees(right);
        }
        return result;
    }
}