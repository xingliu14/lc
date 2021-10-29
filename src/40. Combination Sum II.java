// https://leetcode.com/problems/combination-sum-ii/
// 

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<> ();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<> (), result);
        return result;
    }
    
    private void helper(int[] candidates, int target, int curr, int index, List<Integer> temp, List<List<Integer>> result) {
        if(target == curr) {
            result.add(new ArrayList<Integer> (temp));
            return;
        }
        if(index == candidates.length) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(curr + candidates[i] <= target) {
                temp.add(candidates[i]);
                helper(candidates, target, curr + candidates[i], i + 1, temp, result);
                temp.remove(temp.size() - 1);
                while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i += 1;
                }
            } else {
                break;
            }
        }
        return;
    }
}