// https://leetcode.com/problems/reverse-nodes-in-k-group/
// 基本保持三指针，有时还需要辅助指针，疯狂转转转

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = prev.next, next = curr;
        reverseK(prev, curr, next, k);
        return dummy.next;
    }
    
    private void reverseK(ListNode prev, ListNode curr, ListNode next, int k) {
        ListNode anchor = curr;
        for(int i = 1; i < k; i++) {
            if(next == null) {
                return;
            }
            next = next.next;
        }
        if(next == null) {
            return;
        }
        prev.next = next;
        prev = curr;
        curr = curr.next;
        prev.next = next.next;
        while(prev != next) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        prev = anchor;
        next = curr;
        reverseK(prev, curr, next, k);
        return;
    }
}