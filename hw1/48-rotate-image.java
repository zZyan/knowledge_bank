public class Solution {
    //swap: top and right, left and top, bottom and left
    //top row [0][0:n-2] rightmost [0:n-2][n-1] bottom [n-1][n-1:1] leftmost [n-1:1][0]
    //top_next [0+1][1:n-3] rightmost [1:n-3][n-2] bottom [n-2][n-2:2] leftmost [n-2:2][1]
    public void rotate(int[][] matrix) {
        //edge case
        int n = matrix.length;
        
        if(n<2) return;
        
        for (int i = 0; i<n/2; i++){
            for(int j = 0; j< Math.ceil(((double) n) / 2.); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-i-1];  
                matrix[j][n-i-1] = temp;
            }
            
        }


    }
}