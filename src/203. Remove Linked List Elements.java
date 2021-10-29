// https://leetcode.com/problems/remove-linked-list-elements/
// 删除的时候不需要移动curr

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), curr = dummy, next = head;
        while(next != null) {
            if(next.val == val) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
            next = next.next;
        }
        return dummy.next;
    }
}