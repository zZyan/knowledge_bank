'''
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
'''

# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if intervals == None or len(intervals) == 0:
            return 0;
        elif len(intervals) == 1: 
            return 1;
        
        intervals.sort(key = lambda x: x.start)
        
        roomList = []
        roomList.append([0])
        
        for i in range(len(intervals)): 
            available = False
            for j in range(len(roomList)): 
                if intervals[i].start >= roomList[j][-1]:
                    roomList[j].pop()
                    roomList[j].append(intervals[i].end)
                    available = True
                    break
            
            if not available:
                roomList.append([intervals[i].end])
        
        return len(roomList)
