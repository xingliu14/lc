// https://leetcode.com/problems/interval-list-intersections/
// 就纯if-else怼

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Pair<Integer, Integer>> list = new ArrayList<> ();
        int index1 = 0, index2 = 0;
        while(index1 < firstList.length && index2 < secondList.length) {
            if(firstList[index1][0] > secondList[index2][1]) {
                index2++;
            } else if(firstList[index1][1] < secondList[index2][0]) {
                index1++;
            } else {
                list.add(new Pair<Integer, Integer> (Math.max(firstList[index1][0], secondList[index2][0]), Math.min(firstList[index1][1], secondList[index2][1])));
                if(firstList[index1][1] < secondList[index2][1]) {
                    index1++;
                } else if(firstList[index1][1] > secondList[index2][1]) {
                    index2++;
                } else {
                    index1++;
                    index2++;
                }
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).getKey();
            result[i][1] = list.get(i).getValue();
        }
        return result;
    }
}