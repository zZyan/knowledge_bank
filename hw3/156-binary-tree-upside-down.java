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
 dfs
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null){
            return null;
        }
        
        TreeNode left = root.left, right = root.right, parent = root;
        if (left != null){
            TreeNode ret = upsideDownBinaryTree(left);
            left.left = right;
            left.right = parent;
            root.left = null;
            root.right  = null;
            return ret;    
        }
        return root;
    }
}
