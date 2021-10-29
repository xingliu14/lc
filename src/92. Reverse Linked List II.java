// https://leetcode.com/problems/reverse-linked-list-ii/
// 先找到要reverse的头，再进行翻转

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0, head), reversedHead = dummy;
        for(int i = 1; i < m; i++) {
            reversedHead = reversedHead.next;
        }
        ListNode curr = reversedHead.next, next = curr.next;
        for(int i = m; i <= n; i++) {
            if(i == n) {
                reversedHead.next.next = next;
                reversedHead.next = curr;
            } else {
                ListNode nextNext = next.next;
                next.next = curr;
                curr = next;
                next = nextNext;
            }
        }
        return dummy.next;
    }
}