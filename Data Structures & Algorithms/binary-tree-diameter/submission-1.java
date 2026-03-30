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

    private int max = 0;
    private Map<TreeNode, Integer> heights = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {

        findHeights(root);
        findDiameter(root);

        return max;
    }

    private void findDiameter(TreeNode root) {

        if(root == null) return;

        max = Math.max(max, heights.get(root.left) + heights.get(root.right));

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

    }

    private int findHeights(TreeNode root) {

        if(root == null) {
            heights.put(null, 0);   
            return 0;
        }

        int result = Math.max(findHeights(root.left), findHeights(root.right)) + 1;

        heights.put(root, result);

        return result;


    }
}
