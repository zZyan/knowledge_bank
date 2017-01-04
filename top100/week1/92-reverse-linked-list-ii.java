/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 logic for reverse: 
    pre pointer: before the part to be reversed
    curr pointer: move forward, overwrite edge: pre to curr 
    tail pointer: special case: always point to null; else, outside the loop, next head 
    
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //edge case
        if (head == null || head.next == null || m >= n){
            return head;
        }
        
        //counter move to m-1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (m>1){
            curr = curr.next;
            m--;
            n--;
        }
        // one node before head of reverse
        // System.out.println(curr.val);
        // reverse head.next -> nth, head pointer move back
        // ListNode pre = null;
        ListNode pre = curr;
        ListNode tail = curr.next;
        curr = tail.next;
        while (n>1){
            ListNode temp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = temp;
            
            n--;
        }
        tail.next = curr;
        
        return dummy.next;
        
    }
}