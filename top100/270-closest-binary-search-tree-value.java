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
 bst: 
    left: small, middle, right: larger
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double diff = Double.MAX_VALUE;
        
        //binary search 
        while (root != null){
            if (Math.abs(root.val - target)<diff){
                closest = root.val;
                diff = Math.abs(root.val - target);
            }
            
            if (root.val == target){
                return root.val;
            }
            else if (root.val<target){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        
        return closest;
        
    }
}