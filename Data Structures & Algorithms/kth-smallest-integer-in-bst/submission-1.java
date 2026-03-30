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
    public int kthSmallest(TreeNode root, int k) {

        // In order traversal (DFS)

        int[] res = new int[2];

        // [0] -> Kth Smallest
        // [1] -> Count

        dfs(root, k, res);

        return res[0];
        
    }

    private void dfs(TreeNode node, int k, int[] res) {

        if(node == null) return;

        dfs(node.left, k, res);

        res[1]++;

        if(res[1] == k) {
            res[0] = node.val;
            return;
        }

        dfs(node.right, k, res);

    }
}
