// https://leetcode.com/problems/merge-two-sorted-lists/
// 两边一个一个比较，最后把剩下的加进来

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
        return dummy.next;
    }
}