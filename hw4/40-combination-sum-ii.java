/*
skip current, skip duplicate
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0){
            return result;
        }
        
        int n = candidates.length;
        Arrays.sort(candidates);
        
        helperUnique(candidates, target, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public void helperUnique(int[] candidates, int target, int pos, List<List<Integer>> result, List<Integer> path){
        if (target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++){
            if (target < candidates[i]){
                return;
            }
            if (i != pos && candidates[i] == candidates[i-1]){
                continue;
            }
            
            //continue to next level
            path.add(candidates[i]);
            helperUnique(candidates, target-candidates[i], i+1, result, path);
            path.remove(path.size()-1);
        }
        
        return;
    }
}