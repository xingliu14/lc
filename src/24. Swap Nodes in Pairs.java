// https://leetcode.com/problems/swap-nodes-in-pairs/
// 双指针

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, next = dummy.next;
        while(next != null && next.next != null) {
            curr.next = next.next;
            next.next = curr.next.next;
            curr.next.next = next;
            curr = curr.next.next;
            next = next.next;
        }
        return dummy.next;
    }
}