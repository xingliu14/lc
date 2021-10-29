// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// 双指针

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), one = head, two = head;
        while(two != null) {
            if(two.val != one.val) {
                one.next = two;
                one = one.next;
            }
            two = two.next;
        }
        if(one != null) {
            one.next = null;
        }
        return dummy.next;
    }
}