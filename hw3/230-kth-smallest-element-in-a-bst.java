/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //inorder traversal iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null ||(root.left == null && root.right == null)){
            return root.val;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode current = root;
        
        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.offerLast(current);
                current = current.left;
            }
            
            else {
                current = stack.pollLast();
                k--;
                if (k == 0){
                    break;
                }
                current = current.right;
            }
        }
        
        return current.val;
    }
    
}