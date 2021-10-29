// https://leetcode.com/problems/pascals-triangle-ii/
// 和第一题差不多，只不过每次不需要存之前的了

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<> ();
        result.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<> ();
            curr.add(1);
            for(int j = 0; j < i - 1; j++) {
                curr.add(result.get(j) + result.get(j + 1));
            }
            curr.add(1);
            result = curr;
        }
        return result;
    }
}