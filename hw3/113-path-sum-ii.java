/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 track the path 
 
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        //recursive 
        List<Integer> path = new ArrayList<>();
        dfs(root, sum,result,path);/
        return result;
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path){
        if (root == null) {
            return;
        }
        
        sum-=root.val;
        path.add(root.val);
        
        if (root.left == null && root.right == null){
            if (sum == 0){
                result.add(new ArrayList<Integer>(path));
            } 
        }
        else {
            if(root.left != null){
                dfs(root.left, sum, result, path);
            }
            if (root.right != null){ 
                dfs(root.right, sum, result, path);
            }
        }
        path.remove(path.size()-1);
    }
}