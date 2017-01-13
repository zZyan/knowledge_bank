public class Solution {
    // loop through the matrix, k-- for each loop
    // binary search, counts of numbers smaller than the middle value
    //if larger than k counts - first half; smaller - second half
    // counting number: start from bottom left - if too big, move up, if too small, add counts and move right 

    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        if (k <= 0 || n == 0) {
            return Integer.MAX_VALUE;
        }
        
        int lower = matrix[0][0];
        int upper = matrix[n-1][n-1];
        
        while (lower<upper){
            //find middle!, notice the bucket!
            int mid = lower + ((upper - lower)>>1);
            int count = countSmaller(matrix, n, mid);
            
            if (count < k){
                lower = mid+1;
            }
            else{
                upper = mid;
            }
        }
        return upper;
    }
    
    public int countSmaller(int[][] matrix, int n, int limit){
        int i = n-1;
        int j =0;
        int count = 0;
        while (i>=0 && j<n){
            if (matrix[i][j]<=limit ){
                j++;
                count+= i+1;
            }
            else {
                i--;
            }
        }
        
        return count;
    }
}