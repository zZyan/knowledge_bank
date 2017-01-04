public class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        
        if (digits.length==0) {
            result[0] = 1;
            return result;
        }
        
        result[digits.length] = digits[digits.length-1]+1;
        result[0] = 0;

        for(int i = result.length-2; i>=0; i--){
            //if not the 0th element in result array
            if (i!=0) result[i] = digits[i-1];

            if (result[i+1]==10) {
                result[i+1] = 0;
                result[i] = result[i]+1;
            }
        }
        
        if (result[0] == 1) {
            return result;
        }
        
        else {
            return Arrays.copyOfRange(result, 1, result.length);
        }
        
    }

}