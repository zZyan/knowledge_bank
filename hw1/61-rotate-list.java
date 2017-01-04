/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//new head is kth from the back, stop at k+1 th 
//get kth from the back, 2 pointers
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if (k == 0 || head == null || head.next == null) return head;
        
        ListNode fastPt = head;
        ListNode slowPt = head;
        // ListNode rHead = head;
        int count = 0;
        
        for (int i = 0; i<k; i++){
            
            if (fastPt.next == null) {
                //i == length
                count = i+1;
                k = k%count;
                System.out.println("in the loop");
                System.out.println(count);
                break;
            }
            else fastPt = fastPt.next;
            
        }
        
        if (k==0) return head;

        
        if (fastPt.next == null){
            fastPt = head;
            //re-run the previous loop
            for (int i = 0; i<k; i++){
                fastPt = fastPt.next;
            }
        }

        
        while (fastPt.next != null){
            System.out.println(fastPt.val);
            System.out.println(slowPt.val);
            fastPt = fastPt.next;
            slowPt = slowPt.next;
        }
        //fast: null, slow: k+1 from the back
        ListNode rHead = slowPt.next;
        slowPt.next = null;
        fastPt.next = head;
        
        return rHead;
        
    }
}