public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        if (n < 3) return 0;
        //sort the array
        Arrays.sort(nums);
        
        int count = 0;        
        for (int i = 0; i<n-2; i++){
            int low = i+1;
            int high = n-1;
            while(low<high){
                if (nums[i]+nums[low]+nums[high] < target){
                    count = count + high - low;
                    low++;
                }
                else {
                    high--;
                }
            }
        }
        
        return count;
    }
}