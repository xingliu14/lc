// https://leetcode.com/problems/maximum-subarray-min-product/
// 上面是我自己写的nlogn的divide&conqure的算法，实在优化不动了。下面是神奇on的做法，竟然在同一天见到了两次对一维数组找较小值的stack方法，真是妙啊！

class Solution {
    public int maxSumMinProduct(int[] nums) {
        return (int) (helper(nums, 0, nums.length - 1) % 1000000007);
    }
    
    private long helper(int[] nums, int head, int tail) {
        if(head > tail) {
            return 0;
        }
        if(head == tail) {
            return nums[head] * nums[tail];
        }
        long min = Integer.MAX_VALUE, max = 0, sum = 0;
        List<Integer> minIndex = new ArrayList<> ();
        for(int i = head; i <= tail; i++) {
            if(min == nums[i]) {
                minIndex.add(i);
            } else if(min > nums[i]) {
                minIndex.clear();
                minIndex.add(i);
                min = nums[i];
            }
            sum += nums[i];
        }
        max = sum * min;
        
        max = Math.max(max, helper(nums, head, minIndex.get(0) - 1));
        for(int i = 1; i < minIndex.size(); i++) {
            max = Math.max(max, helper(nums, minIndex.get(i - 1) + 1, minIndex.get(i) - 1));
        }
        max = Math.max(max, helper(nums, minIndex.get(minIndex.size() - 1) + 1, tail));
    
        return max;
    }
}

class Solution {
    long[] preSum;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left_bound = new int[n];
        int[] right_bound = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (!st.isEmpty())
                left_bound[i] = st.peek() + 1;
            else
                left_bound[i] = 0;
            st.add(i);
        }
        st = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (!st.isEmpty())
                right_bound[i] = st.peek() - 1;
            else
                right_bound[i] = n - 1;
            st.add(i);
        }

        preSum = new long[n+1];
        for (int i = 0; i < n; ++i) preSum[i + 1] = preSum[i] + nums[i];
        
        long maxProduct = 0;
        for (int i = 0; i < n; ++i)
            maxProduct = Math.max(maxProduct, getSum(left_bound[i], right_bound[i]) * nums[i]);
        return (int) (maxProduct % 1000_000_007);
    }
    long getSum(int left, int right) { // left, right inclusive
        return preSum[right + 1] - preSum[left];
    }
}