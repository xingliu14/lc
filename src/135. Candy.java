// https://leetcode.com/problems/candy/
// 这个规则的本质就是同时满足左边和右边的要求，那么搞两个array分别代表左边和右边，取他们的最大值就一定保证了同时满足两边

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int[] fromLeft = new int[len], fromRight = new int[len];
        fromLeft[0] = 1;
        fromRight[len - 1] = 1;
        for(int i = 1; i < len; i++) {
            fromLeft[i] = ratings[i - 1] < ratings[i] ? fromLeft[i - 1] + 1 : 1;
            fromRight[len - 1 - i] = ratings[len - i] < ratings[len - 1 - i] ? fromRight[len - i] + 1 : 1;
        }
        int result = 0;
        for(int i = 0; i < len; i++) {
            result += Math.max(fromLeft[i], fromRight[i]);
        }
        return result;
    }
}