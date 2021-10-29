// https://leetcode.com/problems/buildings-with-an-ocean-view/
// one pass scan

class Solution {
    public int[] findBuildings(int[] heights) {
        int max = 0;
        List<Integer> b = new ArrayList<> ();
        for(int i = heights.length - 1; i >= 0; i--) {
            if(max < heights[i]) {
                b.add(i);
                max = heights[i];
            }
        }
        
        int[] result = new int[b.size()];
        for(int i = b.size() - 1; i >= 0; i--) {
            result[b.size() - 1 - i] = b.get(i);
        }
        return result;
    }
}