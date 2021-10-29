// https://leetcode.com/problems/rotate-list/
// 按部就班做即可

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null) {
            return head;
        }
        int len = 0;
        ListNode dummy = new ListNode(0, head), curr = dummy;
        while(curr.next != null) {
            len += 1;
            curr = curr.next;
        }
        int realPlace = k % len;
        if(realPlace == 0) {
            return dummy.next;
        }
        curr = dummy;
        while(realPlace < len) {
            curr = curr.next;
            realPlace += 1;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = dummy.next;
        return newHead;
    }
}