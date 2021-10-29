// https://leetcode.com/problems/linked-list-cycle-ii/
// 我用的是最普通的hashset的做法，还有一个快慢指针的做法，运用了巧妙的数学结论，存下快慢指针相遇的地点，第三个指针再从开头出发，他们会相遇在圆圈起点

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode curr = head;
        Set<ListNode> visited = new HashSet<> ();
        while(curr != null) {
            if (visited.contains(curr)) {
                return curr;
            }
            visited.add(curr);
            curr = curr.next;
        }
        return null;
    }
}