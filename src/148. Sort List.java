// https://leetcode.com/problems/sort-list/
// 看到需要O(nlogn)的时间复杂度那就考虑divide and conqure，再需要两个辅助函数，找中点和merg已经排好序的list。剩下就是递归即可

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode fast = head, slow = head, prev = new ListNode(0, head);
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }
        prev.next = null;
        return slow;
    }
}