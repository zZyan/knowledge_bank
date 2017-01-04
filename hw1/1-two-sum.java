public class Solution {
    public int[] twoSum(int[] nums, int target) {
      // use 2 loops
      int [] result = {0,0};
      
      if (nums.length<2) return result; 
      
      for (int i = 0; i<nums.length-1; i++){
          for (int j = i+1; j<nums.length; j++){
              int temp = nums[i]+nums[j];
              if(nums[i]+nums[j] == target) {
                  result[0] = i;
                  result[1] = j;                  
                  return result;
              }
          }
      }
      return result; 
    }
}