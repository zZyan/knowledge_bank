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
 recursion: 
    starting from root, get counter
    starting from left and right as root, get counter
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int dfs(TreeNode root, int sum){
        int counter = 0;
        if (root == null){
            return counter;
        }
        
        if (sum == root.val){
            counter++;
        }
        counter = counter + dfs(root.left, sum-root.val);
        counter = counter + dfs(root.right, sum-root.val);
        
        return counter;
        
    }
    
}