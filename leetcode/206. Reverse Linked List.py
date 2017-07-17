'''
Reverse a singly linked list.
'''
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        
        pre=None
        # ==curr=head
        
        while head.next != None:
            nextNode = head.next
            head.next=pre 
            pre = head
            head = nextNode
        
        head.next = pre
        return head
