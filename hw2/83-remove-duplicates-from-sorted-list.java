/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //corner 
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                // System.out.println(cur.val);
                cur.next = cur.next.next;
                
            }
            else {
                // pre = cur;
                cur = cur.next;
            }
        }
        
        return dummy.next;
        
    }
}