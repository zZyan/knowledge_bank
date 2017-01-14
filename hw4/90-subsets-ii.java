//duplicates:
//sort, in the for loop at the same recursion level, pass-by statement

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (n == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        //recurse
        addSubset(result, new ArrayList<Integer>(), 0, nums);
        
        return result;
    }
    
    //recursively add subset to result list
    public void addSubset(List<List<Integer>> result, List<Integer> path, int next, int[]nums){
        result.add(new ArrayList<Integer>(path));
        
        if (next == nums.length){
            return;
        }
        
        for (int i = next; i<nums.length; i++){
            if(i != next && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            addSubset(result, path, i+1, nums);
            path.remove(path.size()-1);
        }
    }
}