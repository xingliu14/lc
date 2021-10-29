// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// 双指针

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1;
        while(head < tail) {
            int curr = numbers[head] + numbers[tail];
            if(curr == target) {
                break;
            } else if(curr < target) {
                head++;
            } else {
                tail--;
            }
        }
        int[] result = new int[]{head + 1, tail + 1};
        return result;
    }
}