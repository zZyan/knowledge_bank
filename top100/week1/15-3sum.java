public class Solution {
    // if return index: must use hashset 
    // if contain duplicate and return order: use HashSet
    // if contain duplicate and return no order, sort, pointer, compare with last

    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums.length < 2 || nums == null) return res;
        
        Arrays.sort(nums);
        
        //fix the first number
        int fixer = 0;
        while (fixer < nums.length-2){
            //2 sums 
            int left = fixer + 1;
            int right = nums.length - 1;
            int rest = 0 - nums[fixer];
            
            while (left<right){
                if (nums[left] + nums[right] == rest){
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[fixer]);
                    triplet.add(nums[left++]);
                    triplet.add(nums[right--]);
                    res.add(triplet);
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }   
                }
                
                else if (nums[left] + nums[right] < right){
                    left++;
                }
                else {
                    right--;
                }  
            }
            
            fixer++;
            
            while (fixer<nums.length-2 && nums[fixer] == nums[fixer-1]){
                fixer++;
            }
        }
        
        return res;
        
    }
}

