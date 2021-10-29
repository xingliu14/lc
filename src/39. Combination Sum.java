// https://leetcode.com/problems/combination-sum/
// 标准的backtrack，注意递归的时候不需要加i

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<> (), result);
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, int count, List<Integer> temp, List<List<Integer>> result) {
        if(count == target) {
            result.add(new ArrayList<> (temp));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(count + candidates[i] <= target) {
                temp.add(candidates[i]);
                helper(candidates, target, i, count + candidates[i], temp, result);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
        return;
    }
}