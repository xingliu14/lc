// https://leetcode.com/problems/partition-list/
// 造两个list，一个小于对应值，一个大于等于。最后把它们拼起来。注意就是各种null check。

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = null, smallTail = null, largeHead = null, largeTail = null;
        while(head != null) {
            if(head.val < x) {
                if(smallHead == null) {
                    smallHead = head;
                    smallTail = head;
                } else {
                    smallTail.next = head;
                    smallTail = smallTail.next;
                }
            } else {
                if(largeHead == null) {
                    largeHead = head;
                    largeTail = head;
                } else {
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
            }
            head = head.next;
        }
        
        if(smallHead == null) {
            return largeHead;
        } else {
            smallTail.next = largeHead;
            if(largeTail != null) {
                largeTail.next = null;
            }
        }
        return smallHead;
    }
}