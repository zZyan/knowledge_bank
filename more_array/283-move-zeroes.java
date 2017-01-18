public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return;
        }
        
        //scan from the back
        //two pointers, first zero - 
        int zIndex = n;
        int nzIndex = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                zIndex--;
            }
            else{
                nums[nzIndex] = nums[i];
                nzIndex++;
            }
        }
        
        for (;zIndex<n; zIndex++){
            nums[zIndex] = 0;
        }
    }
}