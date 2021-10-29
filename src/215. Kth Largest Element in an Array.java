// https://leetcode.com/problems/kth-largest-element-in-an-array/
// heap能用一些空间复杂度换一些时间复杂度

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.poll();        
  }
}