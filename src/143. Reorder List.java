// https://leetcode.com/problems/reorder-list/
// 我这是简单的把linkedlist变成了arraylist，但是还可以把它变成三个小题：找到中点分开成两个list、reverse第二个list、两个list相交叉

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        List<ListNode> list = new ArrayList<> ();
        ListNode prev = head, curr = head.next;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        boolean fromHead = false;
        while(list.size() > 0) {
            int target = fromHead ? 0 : list.size() - 1;
            curr = list.get(target);
            list.remove(target);
            prev.next = curr;
            prev = curr;
            fromHead = !fromHead;
        }
        prev.next = null;
        return;
    }
}