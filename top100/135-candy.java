/*
compared with neighbor, higher rating, increment by one, lower or equal does not change
from left and from right, 
*/
public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        
        if (length == 0) return 0;
        if (length == 1) return 1;
        
        int res = 0;
        int [] candy = new int[length];
        //scan from left
        for (int i = 0; i<length; i++){
            if (i>0 && ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
            else{
                candy[i] = 1;
            }
        }
        
        for (int i = length-1; i>=0; i--){

            if (i<length-1 && ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i],candy[i+1]+1);
            }
            
            res += candy[i];
            
        }
        
        return res; 
    }
}