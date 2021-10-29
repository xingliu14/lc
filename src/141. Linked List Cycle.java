// https://leetcode.com/problems/linked-list-cycle/
// 经典的快慢指针问题

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}