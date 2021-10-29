// https://leetcode.com/problems/combinations/
// 标准backtrack，注意最开始要return长度已然不够的

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<> ();
        helper(n, k, new ArrayList<> (), result, 1);
        return result;
    }
    
    private void helper(int n, int k, List<Integer> curr, List<List<Integer>> result, int index) {
        if(n - index + 1 + curr.size() < k) {
            return;
        }
        if(curr.size() == k) {
            result.add(new ArrayList<> (curr));
            return;
        }
        for(int i = index; i <= n; i++) {
            curr.add(i);
            helper(n, k, curr, result, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}