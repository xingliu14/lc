// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
// 用sort比较简单，然后这种数组大小的题就很适合stack

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<> (), reversePq = new PriorityQueue<> (
                                                                                (a, b) -> b - a);
        for(int num : nums) {
            pq.offer(num);
            reversePq.offer(num);
        }
        int head = 0, tail = nums.length - 1;
        while(!pq.isEmpty() && pq.poll() == nums[head]) {
            head++;
        }
        while(!reversePq.isEmpty() && reversePq.poll() == nums[tail]) {
            tail--;
        }
        
        return Math.max(0, tail - head + 1);
    }
}

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}