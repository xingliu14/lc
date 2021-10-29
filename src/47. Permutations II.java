// https://leetcode.com/problems/permutations-ii/
// 如果有重复那就要sort加跳过重复的步骤

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(nums);
        helper(result, nums, new ArrayList<> (), new HashSet<> ());
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> temp, Set<Integer> set) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<> (temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(i)) {
                set.add(i);
                temp.add(nums[i]);
                helper(result, nums, temp, set);
                temp.remove(temp.size() - 1);
                set.remove(i);
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i += 1;
                }
            }
        }
    }
}