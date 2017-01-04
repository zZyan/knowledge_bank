/*
brutal force: calculate, save, sort
from 2nd order binormial: vertical line of symmetry - two pointer, scan from center
better: scan from two ends
note: 
    a>0 vs. a<0
    when to move to the next
*/
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length]; 
        int n = nums.length;
        //corner case
        if (n == 0 ) return result; 
        
        int left = 0;
        int right = n - 1;
        //order to be save
        int index = a>=0 ? n-1 : 0;

        while (left<=right){
            int leftNum = quad(nums[left], a, b, c);
            int rightNum = quad(nums[right], a, b, c); 
            if (a>=0){
                // two sides are largest
                result[index--] = quad(nums[left], a, b, c)>=quad(nums[right], a, b, c) ? quad(nums[left++], a, b, c):quad(nums[right--], a, b, c);
            }
            else{
                // two sides are smallest
                result[index++] = quad(nums[left], a, b, c)<=quad(nums[right], a, b, c) ? quad(nums[left++], a, b, c):quad(nums[right--], a, b, c);
            }
        }
        
        return result;
    }
    
    private int quad(int x, int a, int b, int c){
        return a*x*x+b*x+c;
    }
}