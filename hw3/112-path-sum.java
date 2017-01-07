/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum){
        //recursive
        if (root == null) {
            return false;
        }
        
        sum-= root.val;
        
        if (root.left == null && root.right == null){
            return sum == 0;
        }
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}