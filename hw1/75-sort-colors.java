public class Solution {
    public void sortColors(int[] nums) {
        //back and front pointers, and one moving forward pointer, sort the middle
        int front = 0, back = nums.length -1, i = 0;
        while (i <= back) {
            if (nums[i] == 0){
               //swap with front
               nums[i] = nums[front];
               nums[front] = 0;
               front++;
               i++;//left is sorted, front is pointing at 1
            }
            else if (nums[i] == 2){
               //swap with front
               nums[i] = nums[back];
               nums[back] = 2;
               back--;
            }
            else {
                i++;
            }
        }
    }
    
}