/*
class constructor, global variable and instantiated in constructor
	this.window = new ArrayDeque<>();
*/


public class MovingAverage {

    /** Initialize your data structure here. */
    public Deque<Integer> window;
    public int size;
    public MovingAverage(int size) {
        //linkedlist, initialize, to all zeros 
        this.window = new ArrayDeque<>();
        this.size = size;
    }
    
    public double next(int val) {
        //update
        this.window.offerLast(val);
        int len = window.size();
        if (size<len){
            this.window.pollFirst();  
        }
        
        int sum = 0;
        
        for (Integer j: window){
            sum =  sum + j;
        }
        
        return sum/(double)window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */