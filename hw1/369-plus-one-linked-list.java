/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// 1st sol: reverse linkedlist, add one from left, increment the next if 9+1; reverse back; O(n), 3n
//2nd sol: if each node only visited once;pass two node, 
public class Solution {
    public ListNode plusOne(ListNode head) {

        if (head == null) return head;
        
        ListNode msd = new ListNode(0);
        msd.next = head;
        
        plusOnePre(head, msd);
        if (msd.val == 1){
            return msd;
        }
        else return head;

    }
    
    //update the least significant digit
    //take the current node and previous node
    public void plusOnePre(ListNode head, ListNode pre){
        if (head.next == null){
            head.val = head.val+1;
            if (head.val == 10){
                head.val = 0;
                pre.val = pre.val+1;
            }
            return;
        }
        
        plusOnePre(head.next,head);
        
        if (head.val == 10){
            head.val = 0;
            pre.val = pre.val+1;
        }
        
        return;
    }
}