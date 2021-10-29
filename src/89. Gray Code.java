// https://leetcode.com/problems/gray-code/
// 每一次循环一个数字就把之前的翻倍，然后翻倍的时候只需要在前面加上代表这一位数的一个1即可。

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<> ();
        result.add(0);
        for(int i = 0; i < n; i++) {
            int currListSize = result.size();
            for(int j = 0; j < currListSize; j++) {
                int curr = result.get(currListSize - j - 1);
                result.add(curr | 1 << i);
            }
        }
        return result;
    }
}