/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        while (fast != null && fast.next != null){
            fast =  fast.next.next;
            slow = slow.next;
            
            if (slow == fast){
                hasCycle = true;
                break;   
            }  
        }
        
        if (!hasCycle) return null;
        
        
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
        
    }
}