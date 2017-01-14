public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      int n = nums.length;
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      
      if (n == 0) {
        return result;
      }
      //recurse
      boolean[] visited = new boolean[nums.length];
      Arrays.sort(nums);
      permuteHelper(result, new ArrayList<Integer>(), visited, nums);
      
      return result;
           
    }    
  
    public void permuteHelper(List<List<Integer>> result, List<Integer> path, 
                              boolean[] visited, int[] nums){
      if (path.size() == nums.length){
        result.add(new ArrayList<Integer>(path));
      }
      
      for (int i = 0; i<nums.length; i++){
        if (visited[i] || (i!= 0 && nums[i] == nums[i-1] && visited[i-1])){
          continue;
        }
        path.add(nums[i]);
        visited[i] = true;
        permuteHelper(result, path, visited, nums);
        path.remove(path.size()-1);
        visited[i] = false;
          
      }
    }
}
