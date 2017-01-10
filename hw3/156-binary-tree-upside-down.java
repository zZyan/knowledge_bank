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
 traverse to left most, find its parent, rotate three nodes
 move up same
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
    
        Deque<TreeNode> stack = new ArrayDeque<>();
        //move left to the bottom
        while (root.left!=null){
            stack.offerLast(root);
            root = root.left;
        }
        TreeNode current = stack.pollLast();
        
        TreeNode newRoot = rotateNodes(current);
        TreeNode newParent = newRoot;
        while (!stack.isEmpty()){
            current = stack.pollLast();
            // System.out.println(current.val);
            newParent.right = rotateNodes(current);
            newParent = newParent.right;
        }
        return newRoot;
        
    }
    
    public TreeNode rotateNodes(TreeNode parent){
        TreeNode newParent = new TreeNode(parent.left.val);
        newParent.left = parent.right;
        newParent.right = parent;
        parent.left = null;
        parent.right = null;
        
        return newParent;
    }
}