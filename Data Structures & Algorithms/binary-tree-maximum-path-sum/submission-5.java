/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        
        dfs(root);

        return maxPathSum;

    }

    private int dfs(TreeNode node) {

        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        maxPathSum = Math.max(maxPathSum, node.val + left + right);

        return Math.max(0, Math.max(node.val + left, node.val + right));

    }
}
