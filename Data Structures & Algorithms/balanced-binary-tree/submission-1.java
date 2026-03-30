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

    private Map<TreeNode, Integer> heights = new HashMap<>();

    public boolean isBalanced(TreeNode root) {

        findHeights(root);
        return isBalancedHelper(root);
    }

    private boolean isBalancedHelper(TreeNode root) {

        if(root == null) return true;

        int left = heights.get(root.left);
        int right = heights.get(root.right);

        if(Math.abs(left - right) > 1) return false;

        return isBalancedHelper(root.left) && isBalancedHelper(root.right);

    }



    private int findHeights(TreeNode root) {

        if(root == null) {
            heights.put(root, 0);
            return 0;
        }

        int leftHeight = findHeights(root.left);
        int rightHeight = findHeights(root.right);

        int result = Math.max(leftHeight, rightHeight) + 1;

        heights.put(root, result);

        return result;

    }
}
