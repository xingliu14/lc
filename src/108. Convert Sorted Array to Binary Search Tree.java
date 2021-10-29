// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// 关键是获得subArrya的方法

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length, mid = len / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        curr.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, len));
        return curr;
    }
}