/*
remember the previous int, 
    if curr = pre + 1, count++; 
    else append Integer.toString(curr-count) + "->" + Integer.toString(curr)
note:
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res =new ArrayList<String>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        if (n == 1){
            res.add(Integer.toString(nums[0]));
            return res;
        }
        
        int count = 0;
        
        for (int i = 0; i<n; i++){
            if (i != n-1 && nums[i] == nums[i+1]-1){
                count++;
            }
            else{
                if (count == 0){
                    res.add(Integer.toString(nums[i]));
                }
                else{
                    String temp = Integer.toString(nums[i]-count) + "->" + Integer.toString(nums[i]);
                    res.add(temp);
                    count = 0;
                }
            }
        }
       
        return res;
    }
}