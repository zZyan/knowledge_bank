public class Solution {
    
    // recursion, loop through the remaining number
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 0) {
            return result;
        }
        
        //recurse
        permuteHelper(result, new ArrayList<Integer>(), nums);
        
        return result;   
    }
    
    public void permuteHelper(List<List<Integer>> result, List<Integer>path, int[]nums){
        
        if (path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i: nums){
            // already contain this number
            if (path.contains(i)){
                continue;
            }
            path.add(i);
            permuteHelper(result, path, nums);
            path.remove(path.size()-1);
            
        }
    }
    
    
}