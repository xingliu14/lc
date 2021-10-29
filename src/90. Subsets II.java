// https://leetcode.com/problems/subsets-ii/
// 对于有重复的，再退出的时候还要跳过所有重复的即可

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<> ();
        helper(nums, result, new ArrayList<Integer> (), 0);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> curr, int index) {
        if(index >= nums.length) {
            result.add(new ArrayList<> (curr));
            return;
        }
        curr.add(nums[index]);
        helper(nums, result, curr, index + 1);
        curr.remove(curr.size() - 1);
        index += 1;
        while(index < nums.length && nums[index] == nums[index - 1]) {
            index += 1;
        }
        helper(nums, result, curr, index);
    }
}