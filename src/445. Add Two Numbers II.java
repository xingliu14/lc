// https://leetcode.com/problems/add-two-numbers-ii/solution/
// 有点蠢，为了不换原数组，结果新数组搞来搞去

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // find the length of both lists
        int n1 = 0, n2 = 0;
        ListNode curr1 = l1, curr2 = l2;
        while (curr1 != null) {
            curr1 = curr1.next; 
            ++n1;    
        }
        while (curr2 != null) {
            curr2 = curr2.next; 
            ++n2;    
        }
            
        // parse both lists
        // and sum the corresponding positions 
        // without taking carry into account
        // 3->3->3 + 7->7 --> 3->10->10--> 10->10->3
        curr1 = l1; 
        curr2 = l2;
        ListNode head = null;
        while (n1 > 0 && n2 > 0) {
            int val = 0;
            if (n1 >= n2) {
                val += curr1.val; 
                curr1 = curr1.next; 
                --n1;    
            }
            if (n1 < n2) {
                val += curr2.val; 
                curr2 = curr2.next;
                --n2;    
            }
                
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;    
        }

        // take the carry into account
        // to have all elements to be less than 10
        // 10->10->3 --> 0->1->4 --> 4->1->0
        curr1 = head;
        head = null;
        int carry = 0;
        while (curr1 != null) {
            // current sum and carry
            int val = (curr1.val + carry) % 10;
            carry = (curr1.val + carry) / 10;
            
            // update the result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;

            // move to the next elements in the list
            curr1 = curr1.next;    
        }
        
        // add the last carry
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;    
        }

        return head;
    }
}