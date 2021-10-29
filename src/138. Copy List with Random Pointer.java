// https://leetcode.com/problems/copy-list-with-random-pointer/
// 使用map来存新旧对应，注意要用putIfAbsent，防止有些random是指向自己的

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<> ();
        Node curr = head;
        while(curr != null) {
            map.putIfAbsent(curr, new Node(curr.val));
            Node currCopy = map.get(curr);
            if(curr.random != null) {
                map.putIfAbsent(curr.random, new Node(curr.random.val));
                Node currRandomCopy = map.get(curr.random);
                currCopy.random = currRandomCopy;
            }
            if(curr.next != null) {
                map.putIfAbsent(curr.next, new Node(curr.next.val));
                Node currNextCopy = map.get(curr.next);
                currCopy.next = currNextCopy;
            }
            curr = curr.next;
        }
        return map.get(head);
    }
}