/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
/*
take out the integer from the List and put back to the Deque, approx. DFS
    use getList() to get list from NestedInteger class
    use ArrayDeque to implement stack, note, offerFirst pollFirst, peek() - head element
    
*/
 
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> intArray = new ArrayDeque<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList.isEmpty()){
            return;
        }
        //push to the Deque from front 
        for (NestedInteger nl: nestedList){
            intArray.offerFirst(nl);
        }
    }

    @Override
    public Integer next() {
        return intArray.pollLast().getInteger();
        
    }

    @Override
    //flattern the NestedList on top 
    public boolean hasNext() {
        //
        if (intArray.isEmpty()){
            return false;
        }
        
        while(!intArray.isEmpty()){
            NestedInteger temp = intArray.peekLast();
            if (temp.isInteger()){
                return true;
            }
            
            intArray.pollLast();
            
            for (int i = temp.getList().size()-1; i>=0; i--){
                intArray.offerLast(temp.getList().get(i));    
                // System.out.println("aa");
            }
        }
        
        return false; 
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */