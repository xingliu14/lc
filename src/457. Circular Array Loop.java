// https://leetcode.com/problems/circular-array-loop/
// dfs，然后每次需要维护一个现在的路径

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        Set<Integer> visited = new HashSet<> ();
        for(int i = 0; i < nums.length; i++) {
            if(!visited.contains(nums[i])) {
                Set<Integer> curr = new HashSet<> ();
                if(dfs(nums, i, visited, nums[i] > 0, curr)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int[] nums, int i, Set<Integer> visited, boolean dir, Set<Integer> curr) {
        visited.add(i);
        curr.add(i);
        int next_i = (i + nums[i]) % nums.length;
        if(next_i < 0) {
            next_i += nums.length;
        }
        if(nums[next_i] > 0 != dir || next_i == i) {
            return false;
        }
        if(curr.contains(next_i)) {
            return true;
        }
        if(visited.contains(next_i)) {
            return false;
        }
        return dfs(nums, next_i, visited, dir, curr);
    }
}