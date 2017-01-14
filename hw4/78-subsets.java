/*
dfs
    order does matter in subset
    fix one number, choose next
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 0) {
            return result;
        }
        
        // Arrays.sort(nums);
        //recurse
        subsetHelper(result, new ArrayList<Integer>(), nums, 0);
        
        return result;
    }
    
    public void subsetHelper(List<List<Integer>> result, List<Integer> path, int[]nums, int next){
        
        result.add(new ArrayList<Integer>(path));
        
        if(next == nums.length){
            return;
        }
        // test: 0 1 2
        for (int i = next; i<nums.length; i++){
            path.add(nums[i]);
            subsetHelper(result, path, nums, i+1);
            path.remove(path.size()-1);
        }
    }
    
}