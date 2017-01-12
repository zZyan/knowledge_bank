/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // dfs to bottom, get height at each node, 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        if (Math.abs(depth(root.left)-depth(root.right))>1){
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth (TreeNode root){
        if (root == null){
            return 0;
        }
        
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}