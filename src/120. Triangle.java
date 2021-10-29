// https://leetcode.com/problems/triangle/
// 典型用dp

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = new ArrayList<> ();
        prev.add(triangle.get(0).get(0));
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> curr = new ArrayList<> ();
            curr.add(prev.get(0) + triangle.get(i).get(0));
            for(int j = 1; j < i; j++) {
                curr.add(Math.min(prev.get(j - 1), prev.get(j)) + triangle.get(i).get(j));
            }
            curr.add(prev.get(i - 1) + triangle.get(i).get(i));
            prev = curr;
        }
        int result = Integer.MAX_VALUE;
        for(int i : prev) {
            result = Math.min(result, i);
        }
        return result;
    }
}