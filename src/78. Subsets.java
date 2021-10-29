// https://leetcode.com/problems/subsets/
// 依然backtrack，因为需要把每一个都存进去，所以最后还有单独的一个add

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        helper(nums, result, new ArrayList<Integer> (), 0);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> curr, int index) {
        if(index == nums.length) {
            result.add(new ArrayList<> (curr));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, result, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
        result.add(new ArrayList<> (curr));
    }
}