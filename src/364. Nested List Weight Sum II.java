// https://leetcode.com/problems/nested-list-weight-sum-ii/
// 多加一步找最大深度。

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList, 1);
        return getSum(nestedList, maxDepth);
    }
    
    private int findMaxDepth(List<NestedInteger> nestedList, int currDepth) {
        int maxDepth = currDepth;
        for(NestedInteger ni : nestedList) {
            if(!ni.isInteger()) {
                maxDepth = Math.max(maxDepth, findMaxDepth(ni.getList(), currDepth + 1));
            }
        }
        return maxDepth;
    }
    
    private int getSum(List<NestedInteger> nestedList, int currDepth) {
        int sum = 0;
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                sum += ni.getInteger() * currDepth;
            } else {
                sum += getSum(ni.getList(), currDepth - 1);
            }
        }
        return sum;
    }
}