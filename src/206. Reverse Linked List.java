// https://leetcode.com/problems/reverse-linked-list/
// 三指针动来动去

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode prev = null, curr = head, next = head.next;
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}