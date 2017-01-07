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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        // use stack to save the nodes
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offerLast(root);
        // use another stack to save the states of the nodes
        Deque<Boolean> visited = new ArrayDeque<Boolean>();
        visited.offerLast(false);
        
        TreeNode curr;
        boolean v;
        while (!stack.isEmpty()){
            curr = stack.pollLast();
            v = visited.pollLast();
            if (v){
                result.add(curr.val);
            }
            else {
                stack.offerLast(curr);
                visited.offerLast(true);
                
                if (curr.right != null){
                    stack.offerLast(curr.right);
                    visited.offerLast(false);
                }
                if (curr.left != null){
                    stack.offerLast(curr.left);
                    visited.offerLast(false);
                }
            }
        }
        
        return result;
    }
}