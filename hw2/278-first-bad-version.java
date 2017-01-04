/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n < 2 && !isBadVersion(n)) return 0;
        if(n<2 && isBadVersion(n)) return n; 
        
        int low = 1, high = n;
        
        while (low<high){
            //cannot add first and /2, due to limit of int
            int middle = low+(high-low)/2;
            
            if (isBadVersion(middle)){
                high = middle;
            }
            else{
                low = middle+1;
            }
        }
        
        return low;
    }
}