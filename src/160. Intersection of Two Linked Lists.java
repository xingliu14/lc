// https://leetcode.com/problems/intersection-of-two-linked-lists/
//还有一个2 pointer的方法，循环跑步，第二圈就会在intersection相遇

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<> ();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}