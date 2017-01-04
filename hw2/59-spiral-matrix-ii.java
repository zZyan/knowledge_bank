public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //corner
        if (n == 0) return matrix; 
        
        int top = 0, bottom = n-1, left = 0, right = n-1, k = 1;
        
        while (top<=bottom  && left<=right){
            //top row
            for (int a = left; a<=right; a++){
                matrix[top][a] = k++;
            }
            top++;
            
            for (int b = top; b<=bottom; b++){
                matrix[b][right] = k++;
            }
            right--;
            
            for (int c = right; c>=left; c--){
                matrix[bottom][c] = k++;
            }
            bottom--;
            
            for (int d = bottom; d>=top; d--){
                matrix[d][left] = k++;
            }
            left++;
        }
        
        return matrix;    
        
    }
}