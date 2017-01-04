
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //count from back n == count forward, length-n 
        //count length - n == count n then count to end 
        
        if (head == null || n == 0) return head;
        
        ListNode temp = new ListNode(0);
        ListNode slow = temp;
        ListNode fast = temp;
        temp.next = head;
        
        while(n>0){
            fast = fast.next;
            n--;
        }
        

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return temp.next;
        
        
    }
}