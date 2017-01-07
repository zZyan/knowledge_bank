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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        // stack.offerLast(root);
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr != null){
            //go to left
            if (curr != null){
                // System.out.println(stack.peekLast().val);
                stack.offerLast(curr);
                curr = curr.left;
            }
            //go to right
            else{
                curr = stack.pollLast();
                result.add(curr.val);
                curr = curr.right;                
            }
        }
        
        return result;
    }
}