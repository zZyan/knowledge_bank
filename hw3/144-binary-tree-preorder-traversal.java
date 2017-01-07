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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        // result.add(root.val);
        stack.offerLast(root);
        
        while (!stack.isEmpty()){
            TreeNode top = stack.pollLast();
            result.add(top.val);

            if (top.right!=null){
                stack.offerLast(top.right);
            }            
            
            if(top.left != null){
                stack.offerLast(top.left);
            }
        }
        
        return result;
    }
}