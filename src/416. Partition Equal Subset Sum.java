// https://leetcode.com/problems/partition-equal-subset-sum/submissions/
// 这个方法似乎和dp一样，但是用Map比用2D-array慢很多

class Solution {
    Map<Integer, Set<Integer>> visited = new HashMap<> ();
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        
        return backtrack(nums, 0, 0, sum / 2);
    }
    
    private boolean backtrack(int[] nums, int index, int curr, int target) {
        if(curr == target) {
            return true;
        }
        if(curr > target || inVisited(index, curr)) {
            return false;
        }
        for(int i = index; i < nums.length; i++) {
            if(backtrack(nums, i + 1, curr + nums[i], target)) {
                return true;
            }
            addToVisited(i + 1, curr + nums[i]);
            if(backtrack(nums, i + 1, curr, target)) {
                return true;
            }
        }
        addToVisited(index, curr);
        return false;
    }
    
    private boolean inVisited(int index, int curr) {
        if(!visited.containsKey(index)) {
            return false;
        }
        Set<Integer> set = visited.get(index);
        return set.contains(curr);
    }
    
    private void addToVisited(int index, int curr) {
        Set<Integer> set = visited.getOrDefault(index, new HashSet<> ());
        set.add(curr);
        visited.put(index, set);
    }
}