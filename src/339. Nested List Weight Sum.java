// https://leetcode.com/problems/nested-list-weight-sum/
// 理解了数据结构，直接递归很方便

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> nl, int depth) {
        int sum = 0;
        for(NestedInteger ni : nl) {
            if(ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += helper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}