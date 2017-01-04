public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0) return result;
        
        int minM = 0, minN = 0, lenM = matrix.length, lenN = matrix[0].length;
        
        while(lenM>minM && lenN>minN){
            for (int a = minN; a<lenN; a++){
                result.add(matrix[minM][a]);
            }
            minM++;
            if (lenM == minM) break;

            for (int b = minM; b<lenM; b++){
                result.add(matrix[b][lenN-1]);
            }
            lenN--;
            if (lenN == minN) break;
            
            for (int c = lenN-1; c>=minN; c--){
                result.add(matrix[lenM-1][c]);
            }
            lenM--;
            
            for (int d = lenM-1; d>=minM; d--){
                result.add(matrix[d][minN]);
            } 
            minN++;
        }
        return result;
    }
}