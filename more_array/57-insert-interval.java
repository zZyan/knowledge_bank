/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
/*
new space, 
	append, the newInterval and walk to the end
in-place
	base case: if end is smaller than the current Interval's start add to that position, return
	else larger than current Interval's start 
		if start is also larger than current Interval's end; continue the traversal
		else expand the boundary to have the union of the intervals; remove the current one; 
			continue traversal, start is always smaller than current's start
edge case: move to the end, no .hasNext; add to the last

note: iterator 
*/ 
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        
        ListIterator<Interval> it = intervals.listIterator();
        
        while(it.hasNext()){
            Interval temp = it.next();
            //iterator points at next element 
            if (newInterval.end < temp.start){
                // should insert before current
                //move backward by one
                it.previous();
                //add to position before the .next would return
                it.add(newInterval);
                return intervals;
            }
            else{
                if (temp.end < newInterval.start){
                    // entirely smaller
                    continue;
                }
                else{
                    // overlap, expand to boundary
                     newInterval.start = Math.min(newInterval.start,temp.start);
                     newInterval.end = Math.max(newInterval.end,temp.end);
                     //remove last item returned by next() or previous();
                     // this case: the current one - temp
                     it.remove();
                }
            }
        }
        
        //does not has next
        intervals.add(newInterval);

        return intervals;
    }
}