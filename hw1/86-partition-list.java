/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // two linkedlist, one larger, one smaller
        if(head == null || head.next == null) return head;
        
        ListNode lHead = new ListNode(0);
        ListNode lPt = lHead;
        ListNode sHead = new ListNode(0);
        ListNode sPt = sHead;
        
        while(head!=null){

            if (head.val < x) {
                sPt.next = head; 
                sPt = sPt.next;
            }
            else {
                lPt.next = head; 
                lPt = lPt.next;
            }
            
            head = head.next;
        }
        
        sPt.next = lHead.next;
        lPt.next = null;
        
        return sHead.next;
    }
}