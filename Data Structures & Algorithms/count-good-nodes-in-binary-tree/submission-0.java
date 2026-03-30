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

    private int goodCount = 0;

    public int goodNodes(TreeNode root) {

        int max = Integer.MIN_VALUE;

        dfs(root, max);
        
        return goodCount;
    }

    private void dfs(TreeNode root, int max) {

        if(root == null) return;

        if(root.val >= max) goodCount++;

        max = Math.max(root.val, max);

        dfs(root.left, max);
        dfs(root.right, max);

    }
}
