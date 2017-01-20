/*
unique combination, without duplicate
complete graph: n^n; 
    pruning repeated combination
    2 3 6 7 -> 2 3 6 7; 3 6 7; 6 7; 7
    pruning running target = 0; or target < current
    
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //corner case
        if (candidates.length == 0 || target < 0){
            return result;
        }
        Arrays.sort(candidates);    
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
      
        return result;
    }
    
    public void helper(int[] nums, int target, int pos, List<Integer> path, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = pos; i < nums.length; i++){
            if (target < nums[pos]){
                return;
            }
            path.add(nums[i]);
            helper(nums, target-nums[i], i, path, result);
            path.remove(path.size()-1);        
        }
        
        return;
    }
}