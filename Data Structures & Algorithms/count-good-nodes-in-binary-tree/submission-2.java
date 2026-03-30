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

        dfs(root, Integer.MIN_VALUE);
        return goodCount;
        
    }

    private void dfs(TreeNode node, int max) {

        if(node == null) return;

        if(node.val >= max) {
            goodCount++;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);

    }
}
