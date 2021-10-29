// https://leetcode.com/problems/merge-k-sorted-lists/
// Comparator和PriorityQueue的经典用例。

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<> (
            (a, b) -> a.val - b.val);
        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }
        while(!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}