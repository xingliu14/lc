// https://leetcode.com/problems/add-two-numbers/
// 这道题在普通情况下和简单，但是关键就是最后的收尾过程，里面还有一个while循环，因为有可能一直进位。

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, dummy = new ListNode(0), next = dummy;
        int carry = 0;
        while(p1 != null || p2 != null || carry != 0) {
            next.next = new ListNode(0);
            
            if(p1 == null && p2 == null) {
                next.next.val = carry;
                return dummy.next;
            }
            
            if(p1 == null ^ p2 == null) {
                if(p1 == null) {
                    p1 = p2;
                }
                if(carry == 0) {
                    next.next = p1;
                    return dummy.next;
                }
                while(p1 != null && carry + p1.val == 10) {
                    next = next.next;
                    next.next = new ListNode(0);
                    p1 = p1.next;
                }
                next.next.val = (p1 == null ? carry : p1.val + carry);
                if(p1 != null) {
                    next.next.next = p1.next;
                }
                return dummy.next;
            }
            
            next.next.val = (p1.val + p2.val + carry) % 10;
            carry = (p1.val + p2.val + carry) / 10;
            next = next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        return dummy.next;
    }
}