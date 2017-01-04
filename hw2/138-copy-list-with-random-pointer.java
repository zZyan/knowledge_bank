/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        //<oldPt, newPt>
        Map<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode curr  = head;
        RandomListNode newPt = new RandomListNode(curr.label);
        hm.put(curr, newPt);
        curr = curr.next;
        
        while(curr != null){
            RandomListNode temp = new RandomListNode(curr.label);
            newPt.next = temp;
            hm.put(curr, temp);
            curr = curr.next;
            newPt = temp;
        }
        
        for (RandomListNode key: hm.keySet()){
            if (key.random != null){
                hm.get(key).random = hm.get(key.random);
                
            }
        }
        
        return hm.get(head);
    }
}



// issue: point to random number, the number location does not exist yet 
// sol: use hashmap to store the oldPt and newPt and then copy all the RandonListNode
// HashMap <RandomListNode, RandomListNode> hm: oldPt, newPt
// deepcopy, copy the field one by one
