/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// find middle
// reverse the second half, 
// merge two list with left first  

/*
find middle 
    fast and slow pointer
    initialize fast = fast.next; slow stop before middle for even nodes 
reverse linkedlist
    iterative better
    
*/

public class Solution {
    public void reorderList(ListNode head) {
        //find the middle
        if (head == null || head.next == null) return;
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = reverse(slow.next);
        slow.next = null;
        
        // merge 
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        while (head != null && rightHead != null){
            // ListNode temp1 = head.next;
            ListNode temp = rightHead.next;
            rightHead.next = head.next;
            head.next = rightHead;
            head = head.next.next;
            rightHead = temp;
        }
        
        head = dummy.next;

    }
    
    //@ return the head of reversed node 
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        
        // ListNode rHead = null;
        ListNode pre = null;
        while (head != null) {            
            ListNode temp = head.next;
            head.next = pre; 
            pre = head;
            head = temp; 
        }
        return pre;
    }
    
    
}