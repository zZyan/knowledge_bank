/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/*reverse ListNode, merge two, reverse again 
time: O(n) space: in place

*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode head = sum(l1, l2);
        
        return head = reverse(head);
        
    }
    
    //@return head of reversed listnode from a head
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode pre = null;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
    
    public ListNode sum(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        int carry = 0;
        while (l1 != null && l2 != null){
            System.out.println(l1.val);
            l1.val = l1.val + l2.val + carry;
            if (l1.val > 9) {
                l1.val-= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            if (l1.next != null && l2.next == null){
                l2.next = new ListNode(0);
            }
            else if (l1.next == null && l2.next != null){
                l1.next = new ListNode(0);
            }
            else if (){
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (carry == 1){
            l1.next = new ListNode(1);
        }

        
        return dummy.next;
        
    }
    
}