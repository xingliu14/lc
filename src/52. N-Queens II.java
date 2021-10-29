// https://leetcode.com/problems/n-queens-ii/
// 和第一题一样

class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<> ();
        helper(result, n, new HashMap<Integer, Integer> (), new ArrayList<String> ());
        return result.size();
    }
    
    private void helper(List<List<String>> result, int n, Map<Integer, Integer> curr, List<String> temp) {
        if(temp.size() == n) {
            result.add(new ArrayList<> (temp));
            return;
        }
        int currRow = temp.size();
        outerloop:
        for(int i = 0; i < n; i++) {
            if(!curr.values().contains(i)) {
                for(Map.Entry<Integer, Integer> entry : curr.entrySet()) {
                    if(currRow - entry.getKey() == Math.abs(i - entry.getValue())) {
                        continue outerloop;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(j == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
                curr.put(currRow, i);
                helper(result, n, curr, temp);
                temp.remove(currRow);
                curr.remove(currRow);
            }
        }
        return;
    }
}