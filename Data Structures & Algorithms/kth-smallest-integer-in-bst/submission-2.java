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

        List<Integer> res = new ArrayList<>();
        dfs(root, res, k);
        return res.get(k - 1);
          
    }

    private void dfs(TreeNode node, List<Integer> res, int k) {

        if(node == null || res.size() == k) return;

        dfs(node.left, res, k);
        res.add(node.val);
        dfs(node.right, res, k);

    }
}
