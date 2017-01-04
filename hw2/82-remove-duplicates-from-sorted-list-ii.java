/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // peek the next node, if not the same, move on
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //corner
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        int duplicate = head.val-1;
        
        while (current != null){
            if(current.next!=null && current.next.val == current.val){
                duplicate = current.val;
                pre.next = current.next.next;
                current = current.next.next;
            }

            else if (current.val == duplicate){
                pre.next = current.next;
                current = current.next;
            }
            else {
                duplicate = current.val;
                pre = current;
                current = current.next;
            }
            
        }
        return dummy.next;
    }
}