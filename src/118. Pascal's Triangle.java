// https://leetcode.com/problems/pascals-triangle/
// 就一层一层构建

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<> ();
        for(int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<> ();
            if(i == 0) {
                curr.add(1);
            } else {
                List<Integer> prev = result.get(result.size() - 1);
                curr.add(1);
                for(int j = 0; j < i - 1; j++) {
                    curr.add(prev.get(j) + prev.get(j + 1));
                }
                curr.add(1);
            }
            result.add(curr);
        }
        return result;
    }
}