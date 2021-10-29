// https://leetcode.com/problems/insertion-sort-list/
// 简直就是标准解法！

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head), prev = head, curr = head.next;
        while(curr != null) {
            ListNode target = dummy;
            while(target != prev && curr.val > target.next.val) {
                target = target.next;
            }
            if(target == prev) {
                prev = curr;
            } else {
                prev.next = curr.next;
                curr.next = target.next;
                target.next = curr;
            }
            curr = prev.next;
        }
        return dummy.next;
    }
}