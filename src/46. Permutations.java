// https://leetcode.com/problems/permutations/
// backtrack的经典应用

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(result, nums, 0, new ArrayList<Integer> (), new HashSet<Integer> ());
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> temp, Set<Integer> set) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<> (temp));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                temp.add(nums[i]);
                helper(result, nums, 0, temp, set);
                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }
}