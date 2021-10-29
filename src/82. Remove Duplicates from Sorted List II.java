// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
// 依旧是双指针，找到相同的那就一直前进到下一个

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), curr = dummy, next = head;
        while(next != null && next.next != null) {
            int curr_val = next.val;
            if(next.next.val == curr_val) {
                while(next != null && next.val == curr_val) {
                    next = next.next;
                }
            } else {
                curr.next = next;
                curr = curr.next;
                next = next.next;
            }
        }
        curr.next = next;
        return dummy.next;
    }
}